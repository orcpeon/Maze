package path;

public class PathBuilder {
	
	private int turnCount;
	private StringBuilder sb;
	
	public PathBuilder() {
		sb = new StringBuilder();
		turnCount = 0;
	}
	
	public StringBuilder getBuilder() {
		return sb;
	}
	
	public void add(String str) {
		sb.append(str);
		turnCount++;
	}
	
	public String getString() {
		return turnCount +"\n" + sb.toString();
	}
	
	public void clear() {
		sb.delete(0, sb.length());
		turnCount = 0;
	}

}
