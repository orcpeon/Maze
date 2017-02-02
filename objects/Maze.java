package objects;

import java.io.File;

import fileutilities.FileConverter;

/*
 * maze consists of points
 * we get points from the file, interpreting "Y" as a passable point (see Point class), and "N" as unpassable
 * done with FileConverter
 * 
 * maze have to be square or rectangular (to be fixed if there's time)
 */

public class Maze {
	
	private int length;
	private int height;
	private Point[][] maze;
	
	
	public Maze(File file) {		
		FileConverter fc = new FileConverter(file);
		fc.convert();
		maze = fc.getPoints();		
	}
	
	public Point getPoint(int x, int y) {
		return maze[y][x];
	}
	
	public int getLength(int row) {
		return maze[row].length;
	}
	
	public int getHeight() {
		return maze.length;
	}
	
	

}
