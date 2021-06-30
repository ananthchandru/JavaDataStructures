package ds.sorting;

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] a= {5,4,3,2,1};
	//	int[] a= {1,2,3,4,5};
		display(a);
		selectSort(a);

	}
	
	public static void selectSort(int[] a) {
		for(int i=0; i< a.length;i++) {
			int min = i;
			for(int j=i+1; j<a.length; j++) {
				if(a[j] <= a[min]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
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
