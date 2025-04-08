package SearchName;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "GL";
		List<String> fileNames = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			fileNames.add("nomescompletos-0" + i + ".txt");
		}

		SearchFile search = new SearchFile(fileNames, str);
		search.find();
		
		
	}

}
