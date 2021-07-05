package ds.sorting.selectionsort;

public class SelectionSortWhileLoop {

    public static void main(String[] args) {
        int a[] = {3,4,1,5,2};
        display(a);
        selectionSort(a);
    }

    public static void selectionSort(int a[]) {

        int swappedElementIndex = 0;
        do {
            int min = swappedElementIndex;
            for (int i = swappedElementIndex + 1; i < a.length; i++) {
                if (a[i] < a[min]) {
                    min = i;
                }
            }
            if (min >= swappedElementIndex) {
                int temp = a[min];
                a[min] = a[swappedElementIndex];
                a[swappedElementIndex] = temp;
            }
            swappedElementIndex++;
            display(a);
        } while (swappedElementIndex < a.length);
    }

	public static void display(int[] a) {
		for(int element: a) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

}