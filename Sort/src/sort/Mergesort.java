package sort;

import java.util.LinkedList;

public class Mergesort {
	static void split(LinkedList<Integer> l, LinkedList<Integer> l1, LinkedList<Integer> l2) {
		int meio = l.size() / 2;

		for (int i = 0; i < l.size(); i++) {
			if (i < meio)
				l1.add(l.get(i));
			else
				l2.add(l.get(i));
		}
	}

	static LinkedList<Integer> merge(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		LinkedList<Integer> l = new LinkedList<Integer>();

		for (int i = 0, j = 0; i < l1.size() || j < l2.size();) {
			if (i == l1.size()) {
				l.add(l2.get(j++));
			} else if (j == l2.size()) {
				l.add(l1.get(i++));
			} else {
				if (l1.get(i) <= l2.get(j))
					l.add(l1.get(i++));
				else
					l.add(l2.get(j++));
			}

		}

		return l;
	}

	static LinkedList<Integer> mergesort(LinkedList<Integer> l) {
		if (l.size() <= 1)
			return l;

		LinkedList<Integer> left = new LinkedList<Integer>();
		LinkedList<Integer> right = new LinkedList<Integer>();

		split(l, left, right);

		left = mergesort(left);
		right = mergesort(right);

		LinkedList<Integer> result = new LinkedList<Integer>();

		result = merge(left, right);

		return result;
	}

}
