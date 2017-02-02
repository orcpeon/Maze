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
	public void step() {
		
		while(true) {
			
		if (isSolved()) {
			break;
		}
		
		wallFollower.setPlayerDirection();
		log.add(player.getDirection().toAppend());
		player.moveInDirection();
		
		}
	}
	
	//is player on the exit?
	private boolean isSolved() { 
		return (player.getX()==maze.getLength(player.getY())-1 && player.getY()==maze.getHeight()-1);
	}
	
	
	
	
}
