package SearchName;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SearchFile extends Thread{
	
	private String search;
	private List<String> fileNames;
	private List<String> fileNamesSearch;
	private final String FILES_DIR = "src/FileNames/";
	
	private static final Semaphore sem = new Semaphore(2);
	
	public SearchFile(List<String> filesName, String str) {
		this.fileNames = filesName;
		this.search = str;
	}
	
	public void find() {
		this.fileNamesSearch = fileNames;
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < this.fileNames.size(); i++) {
			threads.add(new Thread(this));
		}
		for (Thread thread : threads) {
			thread.start();
		}
	}
	
	private synchronized String getNextFile() {
	    if (fileNamesSearch.isEmpty()) return null;
	    return fileNamesSearch.remove(0);
	}
	
	@Override
	public void run() {
		try {
			sem.acquire();
			
			String fileName = getNextFile();
			if (fileName == null) return;
			
			Path filePath = Paths.get(FILES_DIR, fileName).toAbsolutePath();
			BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()));
			String line;
			int count = 0;
			while ((line = reader.readLine()) != null) {
				count++;
				if (line.toLowerCase().contains(search.toLowerCase())) {
					System.out.println(fileName + " - line: " + count + " - " + line);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sem.release();
	}
}
