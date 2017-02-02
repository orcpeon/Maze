package main;

/*
 * here all the paths are stored
 */

import java.util.ArrayList;

public class PathStorage {
	
	private ArrayList<String> pathList;
	
	public PathStorage() {
		pathList = new ArrayList<String>();
	}
	
	public int determineOptimalLength() {
		int optimal = pathList.get(0).length();
		for(String item : pathList) {
			if (item.length()<optimal) {
				optimal = item.length();
			}
		}
		return optimal;
	}
	
	public String getOptimalPath(int optimal) {
		String returnable = null;
		for (String item : pathList) {
			if (item.length()==optimal) {
				returnable=item;
			}
		}
		return returnable;
	}
	
	

}
