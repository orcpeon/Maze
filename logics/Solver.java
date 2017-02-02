package logics;

/*
 * Moves player, stores moves PathStorage 
 */

import objects.Maze;
import objects.Player;

public class Solver {

	private Player player;
	private Maze maze;
	private WallFollower wallFollower;
	
	public Solver(Player player, Maze maze) {
		this.player = player;
		this.maze = maze;
		wallFollower = new WallFollower(player, maze);
	}
	
	public void step() {
		
		while(true) {
			
		if (isSolved()) {
			break;
		}
		
		wallFollower.setPlayerDirection();
		player.moveInDirection();
		
		}
	}
	
	//is player on the exit?
	private boolean isSolved() { 
		return (player.getX()==maze.getLength(player.getY())-1 && player.getY()==maze.getHeight()-1);
	}
	
	
	
}
