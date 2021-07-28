package ds.sorting.countingsort;

import java.util.Arrays;

public class CountingSort2 {
	
	public static void main(String[] args) {
	    int[] arr = {5,5,7,10,2,3};
	    int n = arr.length;
	    countSort(arr, n);
	    for (int i = 0; i < arr.length; ++i)
	      System.out.print(arr[i]);
	  }
	
	  public static int getMax(int[] arr) {
	    int max = arr[0];
	    for (int i = 1; i < arr.length; i++) {
	      if (arr[i] > max) {
	        max = arr[i];
	      }
	    }
	    return max;
	  }
	  
	  public static void countSort(int[] arr, int n) {
	    int[] countArray = new int[getMax(arr) + 1];
	    Arrays.fill(countArray, 0);
	    for (int i = 0; i < n; i++) {
	      countArray[arr[i]]++;
	    }
	    for (int i = 1; i < countArray.length; i++) {
	      countArray[i] = countArray[i] + countArray[i - 1];
	    }
	    int[] output = new int[n];
	    for (int i = n - 1; i >= 0; i--) {
	      output[countArray[arr[i]] - 1] = arr[i];
	      --countArray[arr[i]];
	    }
	    for (int i = 0; i < n; ++i)
	      arr[i] = output[i];
	  }
}
