package sort;

import java.util.LinkedList;

public class Ex1 {
	static boolean is_sorted(LinkedList<Integer> l) {
		int v = Integer.MIN_VALUE;
		for (int x : l) {
			if (!(v <= x))
				return false;
			v = x;
		}
		return true;
	}

	static final int M = 10;

	static int[] occurrences(LinkedList<Integer> l) {
		int[] occ = new int[M];
		for (int x : l)
			occ[x]++;
		return occ;
	}

	static boolean is_permut(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		int[] occ1 = occurrences(l1);
		int[] occ2 = occurrences(l2);
		for (int i = 0; i < M; i++)
			if (occ1[i] != occ2[i])
				return false;
		return true;
	}

	static void test(LinkedList<Integer> l) {
		System.out.println("           l = " + l);
		int[] old_occ = occurrences(l);
		LinkedList<Integer> sl = Mergesort.mergesort(l);
		int[] new_occ = occurrences(l);
		for (int i = 0; i < M; i++)
			if (old_occ[i] != new_occ[i]) {
				System.out.println("ERRO : mergesort modificou seu parametro");
				System.exit(1);
			}
		System.out.println("mergesort(l) = " + sl);
		if (!is_sorted(sl)) {
			System.out.println("ERRO: o resultado nao esta ordenado");
			System.exit(1);
		}
		if (!is_permut(l, sl)) {
			System.out.println("ERRO : os elementos diferem");
			System.exit(1);
		}
	}

	static LinkedList<Integer> random_list(int len) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		for (int i = 0; i < len; i++)
			l.add((int) (M * Math.random()));
		return l;
	}
}
