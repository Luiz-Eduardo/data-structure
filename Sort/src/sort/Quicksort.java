package sort;

public class Quicksort {
	static void swap(int[] a, int i, int j) {
		if (i != j) {
			a[i] = a[i] + a[j];
			a[j] = a[i] - a[j];
			a[i] = a[i] - a[j];
		}
	}

	static int partition(int[] a, int l, int r) {
		int pivo = l;

		for (int i = l + 1; i < r + 1; i++) {
			if (a[i] < a[l]) {
				pivo += 1;
				swap(a, pivo, i);
			}
		}

		swap(a, pivo, l);

		return pivo;
	}

	static void quickrec(int[] a, int l, int r) {
		if (r > l) {
			int pivo = partition(a, l, r);
			quickrec(a, l, pivo - 1);
			quickrec(a, pivo + 1, r);
		}
	}

	static void quicksort(int[] a) {
		if (a.length > 1)
			quickrec(a, 0, a.length - 1);
	}
}
