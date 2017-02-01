package objects;

import main.Direction;

/*
 * Entity moving through the maze
 */

public class Player {

	private int x;
	private int y;
	private Direction direction;

	public Player() {
		x = 0;
		y = 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void move(char dir) {
		if (dir == 'u') {
			y--;
			direction = Direction.UP;
		} else if (dir == 'l') {
			x--;
			direction = Direction.LEFT;
		} else if (dir == 'd') {
			y++;
			direction = Direction.DOWN;
		} else if (dir == 'r') {
			x++;
			direction = Direction.RIGHT;
		}
	}
	
	//Encapsulate maze and get coordinates of surrounding points, check for passable points
	public void getPossibleDirections() {
		
	}

}
