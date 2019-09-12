package nemo;

import java.util.LinkedList;

public class Cell {
	int x;
	int y;

	Cell(int xx, int yy) {
		x = xx;
		y = yy;
	}

	// Convenção: West=(-1,0), South=(0,+1), East=(+1,0), North=(0,-1)
	Cell west() {
		return new Cell(x - 1, y);
	}

	Cell south() {
		return new Cell(x, y + 1);
	}

	Cell east() {
		return new Cell(x + 1, y);
	}

	Cell north() {
		return new Cell(x, y - 1);
	}

	// Retorna a lista de vizinhos na ordem West, South, East, North
	LinkedList<Cell> neighbors() {
		LinkedList<Cell> l = new LinkedList<Cell>();
		l.add(west());
		l.add(south());
		l.add(east());
		l.add(north());
		return l;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}