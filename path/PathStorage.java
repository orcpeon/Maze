package path;

/*
 * here all the paths are stored
 * and the shortest is determined
 */

import java.util.ArrayList;

public class PathStorage {
	
	private static ArrayList<String> pathList = new ArrayList<String>();
	
	public static ArrayList<String> getList() {
		return pathList;
	}
	
	private static int determineOptimalLength() {  //find the shortest string
		int optimal = pathList.get(0).length();
		for(String item : pathList) {
			if (item.length()<optimal) {
				optimal = item.length();
			}
		}
		return optimal;
	}
	
	public static String getOptimalPath() { //return the shortest path
		int i = determineOptimalLength();
		String returnable = null;
		for (String item : pathList) {
			if (item.length()==i) {
				returnable=item;
			}
		}
		return returnable;
	}
	
	public static boolean isFinallyDone(String path) {
		for (String item : pathList) {
			if (path.equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	
	

}
