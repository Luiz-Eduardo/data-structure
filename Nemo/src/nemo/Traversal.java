package nemo;

import java.util.LinkedList;

public class Traversal {
	static final Ocean ocean = new Ocean(0);
	static final int pathColor = 200;
	static final int deadEndColor = 100;

	static void slow() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
	}

	static void q21() {
		LinkedList<Cell> queue = new LinkedList<Cell>();
		Cell first = new Cell();
		queue.add(0);
		while(!queue.isEmpty()){
			Cell auxiliar = queue.poll();
			
			if(auxiliar.equals(Ocean.isMarlin())){
				
			}
		}
		
		
	}

	static void q22() {

	}

	static final int WEST = 1, SOUTH = 2, EAST = 3, NORTH = 4;

	static void q23() {

	}

	static void backTrack() {

	}
}