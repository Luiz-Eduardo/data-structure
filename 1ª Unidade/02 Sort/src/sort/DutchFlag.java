package sort;

public class DutchFlag {
	static void swap(int[] a, int i, int j) {
		if (i != j) {
			a[i] = a[i] + a[j];
			a[j] = a[i] - a[j];
			a[i] = a[i] - a[j];
		}
	}

	static void dutch_flag(int[] a) {
		int b = 0, i = 0;
		int r = a.length - 1;

		while (i <= r) {
			if (a[i] == 0)
				swap(a, i++, b++);
			else if (a[i] == 2)
				swap(a, i, r--);
			else
				i++;
		}
	}
}
