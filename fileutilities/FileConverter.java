package fileutilities;

import java.io.BufferedReader;

/*
 * Scanner and file are created in the main application method
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import objects.Point;

public class FileConverter {
/*
 * 
 */
	private Scanner reader;
	private Point[][] points;
	private File bf;

	public FileConverter(File file) {
		try {
			bf = file;
			reader = new Scanner(file);
			points = new Point[countRows()][countColumns()];
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
	
	private int countColumns() throws FileNotFoundException {
		Scanner readerT = new Scanner(bf);		
		return readerT.nextLine().length();
	}

	private int countRows() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(bf));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int lines = 0;
		try {
			while (reader.readLine() != null) lines++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}

}
