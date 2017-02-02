package main;

/*
 * Direction, in which player is heading
 * Seems necessary for the wall-follower algorithm 
 */

public enum Direction {

	UP, LEFT, DOWN, RIGHT;

	public Direction switchToRight(Direction dir) {
		Direction returnable = null;
		switch (dir) {
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
}
