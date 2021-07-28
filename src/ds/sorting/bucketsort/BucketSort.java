package ds.sorting.bucketsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
	
	public static void main(String[] args) {
		
	    int[] arr = {5,5,7,10,2,3};
	    int n = arr.length;
	    new BucketSort().bucketsort(arr);
	    
	    for (int i = 0; i < arr.length; ++i)
	      System.out.print(arr[i]);
	  }
	  
	public void bucketsort(int[] input) {
	    //get hash codes
	    final int[] code = hash(input);
	    //create and initialize buckets to ArrayList: O(n)
	    List < Integer > [] buckets = new List[code[1]];
	    for (int i = 0; i < code[1]; i++) {
	      buckets[i] = new ArrayList < Integer > ();
	    }
	    //distribute data into buckets: O(n)
	    for (int i: input) {
	      buckets[hash(i, code)].add(i);
	    }
	    /**
	     * Sort each bucket: O(n).
	     * I mentioned above that the worst case for bucket sort is counting
	     * sort. That's because in the worst case, bucket sort may end up
	     * with one bucket per key. In such case, sorting each bucket would
	     * take 1^2 = O(1). Even after allowing for some probabilistic
	     * variance, to sort each bucket would still take 2-1/n, which is
	     * still a constant. Hence, sorting all the buckets takes O(n).
	     ***/
	    for (List bucket: buckets) {
	      Collections.sort(bucket);
	    }
	    int ndx = 0;
	    //merge the buckets: O(n)
	    for (int b = 0; b < buckets.length; b++) {
	      for (int v: buckets[b]) {
	        input[ndx++] = v;
	      }
	    }
	  }
	
	  private int[] hash(int[] input) {
	    int m = input[0];
	    for (int i = 1; i < input.length; i++) {
	      if (m < input[i]) {
	        m = input[i];
	      }
	    }
	    return new int[] {
	      m,
	      (int) Math.sqrt(input.length)
	    };
	  }
	  
	  private int hash(int i, int[] code) {
	    return (int)((double) i / code[0] * (code[1] - 1));
	  }
	

}
