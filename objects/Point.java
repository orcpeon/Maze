package objects;

/*
 * The point of this class (duh) is to build a maze of such objects,
 * substituting walls with unpassable points and free space with passable ones
 */

public class Point {

	private int x;
	private int y;
	private boolean isPassable;

	public Point(int x, int y, boolean isPassable) {
		this.x = x;
		this.y = y;
		this.isPassable = isPassable;
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

	public boolean getPassable() {
		return isPassable;
	}

	public void setPassable(boolean passability) {
		isPassable = passability;
	}

	// DELETE LATER
	@Override
	public String toString() {
		return ".";
	}

}
