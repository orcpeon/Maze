package main;

import java.io.File;

import fileutilities.FileHandler;
import logics.Cycle;
import logics.Solver;
import objects.Maze;
import objects.Player;
import path.PathBuilder;

public class Test {
	
	public static void main(String[] args) {
		
		File input = new File("maze.txt");
		File output = new File("output.txt");
		
		Maze maze = new Maze(input);
		Player player = new Player(maze.getLength(0), maze.getHeight());
		
	//	WallFollower wallFollower = new WallFollower(player, maze);
		PathBuilder log = new PathBuilder();
		Solver solver = new Solver(player, maze);
		Cycle cycle = new Cycle(solver, log);
		FileHandler handler = new FileHandler();
		
		handler.writeToFile(output, cycle.determineOptimalPath());
	}

}
