package fileutilities;

/*
 * Scanner and file are created in the main application method
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import objects.Point;

public class FileConverter {

	private File file;
	private Scanner reader;
	private Point[][] points;

	public FileConverter(File file) {
		this.file = file;
		try {
			reader = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't locate a file");
			e.printStackTrace();
		}
	}

	// creating Point 2d array to pass to a Maze
	public void convert() {
		for (int i = 0; reader.hasNextLine() && i < countRows(); i++) {
			char[] lineChars = reader.nextLine().toCharArray();
			for (int j = 0; j < lineChars.length; j++) {
				if (lineChars[j] == 'N') {
					points[i][j] = new Point(j, i, false);
				} else if (lineChars[j] == 'Y') {
					points[i][j] = new Point(j, i, true);
				}
			}
		}
	}

	public Point[][] getPoints() {
		return points;
	}

	private int countRows() {
		int count = 0;
		while (reader.hasNextLine()) {
			count++;
		}
		return count;
	}

}
