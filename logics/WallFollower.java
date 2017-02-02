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
	public boolean canMoveRight() { 
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
	public boolean canMoveForward() {

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
	public boolean canMoveLeft() {

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
	
	public void setPlayerDirection() {
		if (canMoveRight()) {
			player.setDirection(Direction.RIGHT);
		} else if (!canMoveRight() && canMoveForward()) {
			return;
		} else if (!canMoveRight() && !canMoveForward() && canMoveLeft()) {
			player.setDirection(Direction.LEFT);
		}
	}

}
