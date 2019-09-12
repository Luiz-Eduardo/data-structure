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
		queue.add(ocean.marlin);
		ocean.setMark(ocean.marlin);

		while (!queue.isEmpty()) {
			Cell auxiliar = queue.poll();
			LinkedList<Cell> vizinhos = auxiliar.neighbors();

			for (int i = 0; i < vizinhos.size(); i++) {
				if (!ocean.isWall(vizinhos.get(i)) && !ocean.isShark(vizinhos.get(i))
						&& !ocean.isMarked(vizinhos.get(i))) {
					queue.add(vizinhos.get(i));
					ocean.setMark(vizinhos.get(i));
				}
			}
		}
	}

	static void q22() {
		LinkedList<Cell> queue = new LinkedList<Cell>();
		queue.add(ocean.marlin);
		ocean.setMark(ocean.marlin);

		boolean flag = false;

		while (!queue.isEmpty()) {
			Cell auxiliar = queue.poll();
			LinkedList<Cell> vizinhos = auxiliar.neighbors();

			for (int i = 0; i < vizinhos.size(); i++) {
				if (ocean.isNemo(vizinhos.get(i))) {
					ocean.setMark(ocean.nemo, ocean.getMark(auxiliar) + 1);
					flag = true;
					break;
				}

				if (!ocean.isWall(vizinhos.get(i)) && !ocean.isShark(vizinhos.get(i))
						&& !ocean.isMarked(vizinhos.get(i))) {
					queue.add(vizinhos.get(i));
					ocean.setMark(vizinhos.get(i), ocean.getMark(auxiliar) + 1);
				}

			}

			if (flag)
				break;
		}
	}

	static final int WEST = 1, SOUTH = 2, EAST = 3, NORTH = 4;

	static void q23() {
		LinkedList<Cell> queue = new LinkedList<Cell>();
		queue.add(ocean.marlin);
		ocean.setMark(ocean.marlin);

		while (!queue.isEmpty()) {
			Cell auxiliar = queue.poll();
			LinkedList<Cell> vizinhos = auxiliar.neighbors();

			for (int i = 0; i < vizinhos.size(); i++) {
				if (!ocean.isWall(vizinhos.get(i)) && !ocean.isShark(vizinhos.get(i))
						&& !ocean.isMarked(vizinhos.get(i))) {

					queue.add(vizinhos.get(i));

					switch (i) {
					case 0:
						ocean.setMark(vizinhos.get(i), EAST);
						break;
					case 1:
						ocean.setMark(vizinhos.get(i), NORTH);
						break;
					case 2:
						ocean.setMark(vizinhos.get(i), WEST);
						break;
					case 3:
						ocean.setMark(vizinhos.get(i), SOUTH);
						break;
					}
				}
			}
		}
	}

	static void backTrack() {
		q22();

		int alpha = ocean.getMark(ocean.nemo);

		LinkedList<Cell> queue = new LinkedList<Cell>();
		queue.add(ocean.nemo);

		do {
			Cell auxiliar = queue.poll();
			LinkedList<Cell> vizinhos = auxiliar.neighbors();

			for (int i = 0; i < vizinhos.size(); i++) {
				if ((alpha - ocean.getMark(vizinhos.get(i))) == 1) {
					queue.add(vizinhos.get(i));
					ocean.setMark((vizinhos.get(i)), pathColor);
					break;
				}
			}

			alpha--;
		} while (!ocean.isMarlin(queue.getFirst()));

	}
}