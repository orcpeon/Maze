package fileutilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

	public void writeToFile(File file, String text) {
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(text);
			writer.close();
		} catch (IOException e) {
			System.out.println("Something unexpected happened");
			e.printStackTrace();
		}		
	}
	
	
}
