package ds.sorting.bubblesort;

public class BubbleSortReverseIteration {

	public static void main(String args[]) {
		int[] a = {5, 4, 3, 2, 1};
//		int[] a = {1,2,3,4,5};
		display(a);
		bubbleSort(a);
	}

	public static void bubbleSort(int[] a) {
		boolean swap = false;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < a[j - 1]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
					swap = true;
				}
				display(a);
				if(!swap) 
					return;
			}
		}
	}

	public static void display(int[] a) {
		for(int element: a) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
