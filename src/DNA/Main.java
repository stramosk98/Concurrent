package DNA;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> fileNames = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			fileNames.add("dna-" + i + ".txt");
		}

		SearchDNA search = new SearchDNA(fileNames);
		search.find();
	}

}
