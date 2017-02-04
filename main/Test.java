package main;

import java.io.File;
import java.io.IOException;

import fileutilities.FileHandler;
import logics.Cycle;
import logics.Solver;
import objects.Maze;
import objects.Player;
import path.PathBuilder;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		File input = new File("maze.txt");
		File output = new File("output.txt");
		output.createNewFile();
		
		Maze maze = new Maze(input);
		Player player = new Player(maze.getLength(0)-1, maze.getHeight()-1);
		
	//	WallFollower wallFollower = new WallFollower(player, maze);
		PathBuilder log = new PathBuilder();
		Solver solver = new Solver(player, maze);
		Cycle cycle = new Cycle(solver);
		FileHandler handler = new FileHandler();
		
		handler.writeToFile(output, cycle.determineOptimalPath());
	}

}
