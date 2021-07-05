package ds.sorting.bubblesort;

public class BubbleSortForLoop {
	
	public static void main(String args[]) {
	//	int[] a = {5, 4, 3, 2, 1};
		int[] a= {1,2,3,4,5};
		display(a);
		bubbleSort(a);
	}

	public static void bubbleSort(int[] a) {

		boolean swap = false;
		
		for(int i=0; i<a.length-1;i++) {
			for(int j = 0; j<a.length-i-1;j++) {
			if (a[j] > a[j+1]) {
				int temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
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
