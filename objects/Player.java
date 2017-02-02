package objects;

import main.Direction;

/*
 * Entity moving through the maze
 */

public class Player {

	private int x;
	private int y;
	private Direction direction;
	private int boundX; //basically the length of a maze >
	private int boundY; //height of a maze ^

	//get boundary values from the Maze class on creation (i. e. create Maze first, then get values-1 (enumeration starts from 0) and pass them to the constructor
	//player cannot move beyond boundary values
	public Player(int boundX, int boundY) {  
		x = 0;
		y = 0;
		this.boundX = boundX;
		this.boundY = boundY;
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
	
	public int getBoundX() {
		return boundX;
	}

	public int getBoundY() {
		return boundY;
	}


	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	//for player input
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
	
	//for solving algorithm
	public void moveInDirection() {
		if (direction==Direction.UP) {
			y--;
		} else if (direction==Direction.LEFT) {
			x--;
		} else if (direction==Direction.DOWN) {
			y++;
		} else if (direction==Direction.RIGHT) {
			x++;
		}		
	}
	
	
	
	
	


}
