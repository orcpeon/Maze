package logics;

import main.Direction;
import objects.Maze;
import objects.Player;

/*
 * This algorithm is better known as a "right hand rule" or a "left hand rule"
 * The hand of your choice should be always touching a wall
 * You basically have to turn right every time possible
 * (I used right hand)
 */

public class WallFollower {

	private Player player;
	private Maze maze;

	public WallFollower(Player player, Maze maze) {
		this.player = player;
		this.maze = maze;
	}

	// check if player can turn right, depending
	// on his direction
	private boolean canMoveRight() { 
		int currentY = player.getY();
		int currentX = player.getX();
		Direction currentDir = player.getDirection();

		if (currentDir == Direction.UP) {
			if (currentX != player.getBoundX() && maze.getPoint(currentX + 1, currentY).getPassable()) {
				return true;
			}
		}
		if (currentDir == Direction.LEFT) {
			if (currentY != 0 && maze.getPoint(currentX, currentY - 1).getPassable()) {
				return true;
			}
		}
		if (currentDir == Direction.DOWN) {
			if (currentX != 0 && maze.getPoint(currentX - 1, currentY).getPassable()) {
				return true;
			}
		}
		if (currentDir == Direction.RIGHT) {
			if (currentX != player.getBoundY() && maze.getPoint(currentX, currentY + 1).getPassable()) {
				return true;
			}
		}
		return false;
	}

	// check if player can move in his current direction
	// used if canTurnRight==false
	private boolean canMoveForward() {

		int currentY = player.getY();
		int currentX = player.getX();
		Direction currentDir = player.getDirection();

		if (currentDir == Direction.UP) {
			if (currentY != 0 && maze.getPoint(currentX, currentY - 1).getPassable()) {
				return true;
			}
		}
		if (currentDir == Direction.LEFT) {
			if (currentX != 0 && maze.getPoint(currentX - 1, currentY).getPassable()) {
				return true;
			}
		}
		if (currentDir == Direction.DOWN) {
			if (currentY != player.getBoundY() && maze.getPoint(currentX, currentY + 1).getPassable()) {
				return true;
			}
		}
		if (currentDir == Direction.RIGHT) {
			if (currentX != player.getBoundX() && maze.getPoint(currentX + 1, currentY).getPassable()) {
				return true;
			}
		}
		return false;
	}

	// check if player can move to the left
	// used if cannot turn right and cannot move forward
	private boolean canMoveLeft() {

		int currentY = player.getY();
		int currentX = player.getX();
		Direction currentDir = player.getDirection();

		if (currentDir == Direction.UP) {
			if (currentX != 0 && maze.getPoint(currentX - 1, currentY).getPassable()) {
				return true;
			}
		}
		if (currentDir == Direction.LEFT) {
			if (currentY != player.getBoundY() && maze.getPoint(currentX, currentY + 1).getPassable()) {
				return true;
			}
		}
		if (currentDir == Direction.DOWN) {
			if (currentY != player.getBoundX() && maze.getPoint(currentX + 1, currentY).getPassable()) {
				return true;
			}
		}
		if (currentDir == Direction.RIGHT) {
			if (currentY != 0 && maze.getPoint(currentX, currentY - 1).getPassable()) {
				return true;
			}
		}
		return false;
	}
	
	
	private boolean isDeadEnd() {
		return (!canMoveRight() && !canMoveForward() && !canMoveLeft());		
	}
	
	
	//setting the direction in which player will later move
	public void setPlayerDirection() {
		if (isDeadEnd()) {
			player.getDirection().reverse(); //direction is reversed in only one situation: dead end
			maze.getPoint(player.getY(), player.getX()).setPassable(false);  //so in order to avoid the infinite loop we're marking the point unpassable			
		} else	if (canMoveRight()) {
			player.getDirection().switchToRight();
		} else if (!canMoveRight() && canMoveForward()) {
			return;
		} else if (!canMoveRight() && !canMoveForward() && canMoveLeft()) {
			player.getDirection().switchToLeft();
		} 
	}

	
	
}
