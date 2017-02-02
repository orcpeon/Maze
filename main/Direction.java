package main;

/*
 * Direction, in which player is heading
 * Seems necessary for the wall-follower algorithm 
 */

public enum Direction {

	UP, LEFT, DOWN, RIGHT;

	public Direction switchToRight() {
		Direction returnable = null;
		switch (this) {
		case UP:
			returnable = Direction.RIGHT;
			break;
		case LEFT:
			returnable = Direction.UP;
			break;
		case DOWN:
			returnable = Direction.LEFT;
			break;
		case RIGHT:
			returnable = Direction.DOWN;
			break;
		}
		return returnable;
	}
	
	//ADD TURN LEFT AND REVERSE
	
	public Direction switchToLeft() {
		Direction returnable = null;
		switch (this) {
		case UP:
			returnable = Direction.LEFT;
			break;
		case LEFT:
			returnable = Direction.DOWN;
			break;
		case DOWN:
			returnable = Direction.RIGHT;
			break;
		case RIGHT:
			returnable = Direction.UP;
			break;
		}
		return returnable;
	}
	
	public Direction reverse() {
		Direction returnable = null;
		switch (this) {
		case UP:
			returnable = Direction.DOWN;
			break;
		case LEFT:
			returnable = Direction.RIGHT;
			break;
		case DOWN:
			returnable = Direction.UP;
			break;
		case RIGHT:
			returnable = Direction.LEFT;
			break;
		}
		return returnable;
	}
	
}
