package ds.sorting.countingsort;

	//Best explanation => http://www.geekviewpoint.com/java/sorting/countingsort
	public class CountingSort {
		
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
	  
	  public static void countSort(int[] input, int k) {
	    // create buckets
	    int counter[] = new int[getMax(input) + 1];
	    // fill buckets
	    for (int i: input) {
	      counter[i]++;
	    }
	    // sort array
	    int ndx = 0;
	    for (int i = 0; i < counter.length; i++) {
	      while (0 < counter[i]) {
	        input[ndx++] = i;
	        counter[i]--;
	      }
	    }
	  }
}
