package ds.sorting;

public class InsertionSort {
	
	public static void main(String[] args) {
		int[] a= {5,4,3,2,1};
	//	int[] a= {1,2,3,4,5};
		insertSort(a);

	}

	public static void insertSort(int[] a) {
		for(int i=1; i< a.length;i++) {
			int temp = a[i];
			int j=i;
			while(j>0 && a[j-1] >= temp) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp;
			display(a);
		}
	}
	
	public static void display(int[] a) {
		for(int element: a) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
