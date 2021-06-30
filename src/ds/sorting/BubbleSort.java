package ds.sorting;

public class BubbleSort {

	public static void main(String[] args) {
	//	int[] a= {5,4,3,2,1};
		int[] a= {1,2,3,4,5};
		bubbleSort(a);
		for(int element: a) {
			System.out.print(element + " ");
		}
	}
	
	public static void bubbleSort(int[] a) {
		boolean swap = false;
		int lastElementIndex = 0;
		while(lastElementIndex < a.length-1) {
			for(int j=0; j<a.length-lastElementIndex-1; j++) {
				if(a[j] > a[j+1]) {
					swap = true;
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			if(!swap) {
				return;
			}
			lastElementIndex++;
		}
	}
}
