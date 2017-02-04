package logics;

/*
 * Moves player, stores moves PathStorage 
 */

import objects.Maze;
import objects.Player;
import path.PathBuilder;

public class Solver {

	private Player player;
	private Maze maze;
	private WallFollower wallFollower;
	private PathBuilder log;
	
	public Solver(Player player, Maze maze) {
		this.player = player;
		this.maze = maze;
		wallFollower = new WallFollower(player, maze);
		log = new PathBuilder();
	}
	
	
	//one player step
	public void step() {  //goes on until player reaches the finish
		
		while(true) {			
		if (isSolved()) {			
			System.out.println("Solved");
			System.out.println(log.getString());
			player.setX(0);
			player.setY(0);
			break;
		}
		
		wallFollower.setPlayerDirection();
		log.add(player.getDirection().toAppend());
		player.moveInDirection();
		
		}
	}
	
	//is player on the exit?
	private boolean isSolved() { 
		return (player.getX()==maze.getLength(0)-1 && player.getY()==maze.getHeight()-1);
	}
	
	public PathBuilder getPathBuilder() {
		return this.log;
	}
	
	
	
}
