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
	
	private Point[][] maze;
	
	
	public Maze(File file){		
		FileConverter fc = new FileConverter(file);
		fc.convert();
		maze = fc.getPoints();	
		System.out.println(maze); //DELETE LATER
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
	
	@Override //DELETE LATER
	public String toString() {
		String add = "";
		for (int i=0;i<getHeight();i++) {
			
			for (int j=0;j<getLength(i);j++) {
				add += ".";
			}
			add+="\n";
		}
		return add;
	}

	
	
	
}
