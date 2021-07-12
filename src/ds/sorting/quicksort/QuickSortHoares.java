package ds.sorting.quicksort;

import java.util.Random;

//Choosing median/random number as pivot is recommended to get O(NLogN) in average cases
// as choosing first number as pivot in a sorted array will lead to O(N^)
public class QuickSortHoares {
	
	public static void main(String a[]) {
		//      int[] input = {24,2,45,20,56,75,2,58,99,53,12};
		int input[] = { 50, 10, 30, 70, 40, 20, 60, 90, 80, 100 };
		// int input[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		// int input[] = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
		//    int input[] = {10, 20, 30, 40, 60, 50, 70, 80, 90, 100};
		System.out.println("Input");
		display(input);
		System.out.println();
		QuickSortHoares quickSortHoare = new QuickSortHoares();
		quickSortHoare.quickSort(input, 0, input.length - 1);
		System.out.println("Output");
		display(input);
	}
	
	void random(int arr[], int low, int high) {
		Random random = new Random();
		int pivot = low + random.nextInt(high - low + 1);
		swap(arr, pivot, high);
	}
	
	void quickSort(int[] a, int left, int right) {
		if (left<right) {
			int mid = partition(a, left, right);
			quickSort(a, left, mid - 1);
			quickSort(a, mid + 1, right);
		}
	}
	
	int partition(int[] array, int low, int high) {
		int i = low;
		int j = high;
		random(array, low, high);
		System.out.println("After pivot pick: ");
		display(array);
		System.out.println();
		int pivot = array[high];
		System.out.println("i: " + i + " j: " + j + " pivot: " + pivot);
		while (true) {
			while (array[i]<pivot)
				i++;
			while (array[j] > pivot)
				j--;
			if (i<j) {
				swap(array, i, j);
				display(array);
			} else
				return j;
		}
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void display(int[] arr) {
		for (int a: arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}