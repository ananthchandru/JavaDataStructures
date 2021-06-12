package ds.arrays;

public class InsertInUnsortedArray {
	
	  static int insert(int arr[], int n, int key, int capacity)
	  {
	    // Cannot insert more elements if n is >= capacity
	    if (n >= capacity)
	      return n;
	    arr[n] = key;
	    return (n + 1); //increment size after insert
	  }
	  public static void main(String[] args)
	  {
	    int[] arr = new int[20];
	    arr[0] = 12;
	    arr[1] = 16;
	    arr[2] = 20;
	    arr[3] = 40;
	    arr[4] = 50;
	    arr[5] = 70;
	    int capacity = 20;
	    int positionToInsert = 6;
	    int i, insertKey = 26;
	    int n;
	    // Insertkey
	    n = insert(arr, positionToInsert, insertKey, capacity);
	  }
}
