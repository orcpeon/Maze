package path;

/*
 * here all the paths are stored
 * and the shortest is determined
 */

import java.util.ArrayList;

public class PathStorage {
	
	private ArrayList<String> pathList;
	
	public PathStorage() {
		pathList = new ArrayList<String>();
	}
	
	public ArrayList<String> getList() {
		return pathList;
	}
	
	private int determineOptimalLength() {  //find the shortest string
		int optimal = pathList.get(0).length();
		for(String item : pathList) {
			if (item.length()<optimal) {
				optimal = item.length();
			}
		}
		return optimal;
	}
	
	public String getOptimalPath(int optimal) { //return the shortest path
		int i = determineOptimalLength();
		String returnable = null;
		for (String item : pathList) {
			if (item.length()==i) {
				returnable=item;
			}
		}
		return returnable;
	}
	
	

}
