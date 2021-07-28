package ds.sorting.shellsort;

public class ShellSort {
	
	public static void main(String[] args) {
		  int[] arr = {10,9,8,7,6,5,4,3,2,1};
		  display(arr);
		  shellSort(arr);
		  display(arr);
	}
	
	public static void display(int[] arr) {
		  System.out.println();
		  for (int i = 0; i < arr.length; i++) {
		    System.out.print(arr[i] + " ");
		  }
	}
	
	public static void shellSort(int[] arr) {
		  int n = arr.length;

	  // Start with a big gap, then reduce the gap
	  for (int gap = n / 2; gap > 0; gap /= 2) {
	    for (int i = gap; i < n; i++) {
	      for (int j = i - gap; j >= 0; j = j - gap) {
	        if (arr[j + gap] >= arr[j]) {
	          break;
	        } else {
	          int tmp = arr[j];
	          arr[j] = arr[j + gap];
	          arr[j + gap] = tmp;
	        }
	        display(arr);
	      }
	    }
	  }
	}

}
