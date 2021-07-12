package ds.sorting.quicksort;

import java.util.Random;


public class QuickSortLomuto {
	
	void random(int arr[], int low, int high) {
		Random random = new Random();
		int pivot = low + random.nextInt(high - low);
		swap(arr, pivot, high);
	}
	/* This function takes last element as pivot,
	    places the pivot element at its correct
	    position in sorted array, and places all
	    smaller (smaller than pivot) to left of
	    pivot and all greater elements to right
	    of pivot */
	int partition(int arr[], int low, int high) {
		//int pivot = arr[high]; 
		//choosing high as pivot directly is not recommended as it might lead to O(N^2) for already sorted array
		//Use random pivot or median as pivot, then swap it with high
		random(arr, low, high);
		System.out.println("After pivot pick: ");
		display(arr);
		System.out.println();
		int pivot = arr[high];
		System.out.println("i: " + low + " j: " + high + " pivot: " + pivot);
		int i = (low - 1); // index of smaller element
		for (int j = low; j<high; j++)
		{
			// If current element is smaller than the pivot
			if (arr[j]<pivot)
			{
				i++;
				swap(arr, i, j);
			}
		}
		// swap arr[i+1] and arr[high] (or pivot)
		swap(arr, i + 1, high);
		display(arr);
		return i + 1;
	}
	/* The main function that implements QuickSort()
	   arr[] --> Array to be sorted,
	   low  --> Starting index,
	   high  --> Ending index */
	void sort(int arr[], int low, int high)
	{
		if (low<high)
		{
			/* pi is partitioning index, arr[pi] is 
           now at right place */
			int pi = partition(arr, low, high);
			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}
	
	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	// Driver program
	public static void main(String args[])
	{
		//    int arr[] = {50, 10, 30, 70, 40, 20, 60, 90, 80, 100};
		// int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		// int arr[] = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
		int arr[] = { 10, 20, 30, 40, 60, 50, 70, 80, 90, 100 };
		int n = arr.length;
		System.out.println("Input");
		display(arr);
		System.out.println();
		QuickSortLomuto ob = new QuickSortLomuto();
		ob.sort(arr, 0, n - 1);
		System.out.println("Output");
		display(arr);
	}
	public static void display(int[] arr) {
		for (int a: arr)
			System.out.print(a + " ");
		System.out.println();
	}
}