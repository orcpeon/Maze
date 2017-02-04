package logics;

import path.PathBuilder;
import path.PathStorage;

/*
 * Executes every cycle from start to finish 
 */

public class Cycle {

	private Solver solver;
	//private PathBuilder log;

	public Cycle(Solver solver/*, PathBuilder log*/) {
		this.solver = solver;
	//	this.log = log;
	}

	/*
	 * every time player finishes the maze, his path is compared to all stored
	 * paths and in case it equals one of them, that means all the possible
	 * solution have been found
	 */

	private void cycle() {
		while (true) {
			solver.step();
			if (PathStorage.isFinallyDone(solver.getPathBuilder().getString())) {
				break;
			}
			PathStorage.getList().add(solver.getPathBuilder().getString());
			System.out.println(PathStorage.getList());
			solver.getPathBuilder().clear();
		}		
	}
	
	//return optimal path, when cycle() is done solving maze
	public String determineOptimalPath() {
		cycle();
		return PathStorage.getOptimalPath();
	}

}
