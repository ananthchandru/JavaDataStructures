package ds.sorting.bubblesort;

public class BubbleSortWhileLoop {

	public static void main(String[] args) {
	//	int[] a= {5,4,3,2,1};
		int[] a= {8,7,6,1,2,3,4,5};
		bubbleSort(a);
		for(int element: a) {
			System.out.print(element + " ");
		}
	}
	
	public static void bubbleSort(int[] arr) {
		boolean swap = false;
		int arrLength = arr.length;
		while(arrLength > 0) {
			for(int i=0; i <arrLength-1; i++) {
				if(arr[i] > arr[i+1]) {
					swap(arr, i, i+1);
					swap = true;
				}
			}
			if(!swap) {
				break;
			}
			arrLength--;
		}
	}

	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
