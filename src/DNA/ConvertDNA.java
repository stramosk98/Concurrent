package DNA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ConvertDNA extends Thread{
	
	private List<String> fileNames;
	private List<String> fileNamesSearch;
	private final String FILES_DIR = "src/FileDNAs/";
	
	private static final Semaphore sem = new Semaphore(2);
	
	public ConvertDNA(List<String> filesName) {
		this.fileNames = filesName;
	}
	
	public void execute() {
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
	
	private synchronized File getFilePath(String file) {
		return Paths.get(FILES_DIR, file).toFile();
	}
	
	@Override
	public void run() {
		try {
			sem.acquire();
			
			String fileName = getNextFile();
			if (fileName == null) return;
			BufferedReader reader = new BufferedReader(new FileReader(getFilePath(fileName)));
			PrintWriter writer = new PrintWriter(getFilePath("new-" + fileName), "UTF-8");
			String line;
			int count = 0;
			List<Integer> invalids = new ArrayList<Integer>();
			while ((line = reader.readLine()) != null) {
				count++;
				StringBuilder newLine = new StringBuilder();
				boolean invalid = false;
				for (int i = 0; i < line.length(); i++) {
					switch (line.charAt(i)) {
					case 'A': newLine.append("T");
						break;
					case 'T': newLine.append("A"); 
						break;
					case 'C': newLine.append("G"); 
						break;
					case 'G': newLine.append("C"); 
						break;
					default: invalid = true;
					}
				}
				
				if (invalid) {
					invalids.add(count);
					newLine.insert(0, "***FITA INVALIDA - ");
				}
				
				writer.println(newLine);
			}
			
			reader.close();
			writer.close();
			
			System.out.println("--- " + fileName + " ---");
			System.out.println("O total de fitas é " + count);
			System.out.println("O total de fitas validas é " + (count - invalids.size()));
			System.out.println("O total de fitas invalidas é " + invalids.size());
			System.out.println("As linhas invalidas são " + invalids);
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
