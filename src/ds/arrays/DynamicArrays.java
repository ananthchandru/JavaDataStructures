package ds.arrays;

import java.util.Arrays;

//First we need members and constructors to initialise the array.
//reference - https://www.geeksforgeeks.org/how-do-dynamic-arrays-work/

public class DynamicArrays {
	
	private int[] array;
	private int size;
	private int count;
	
	public DynamicArrays(int arraySize) {
		array = new int[arraySize];
		size = arraySize;
		count = 0;
	}
	
	public void add(int element) {
		if(size == count) {
			growArray();
		}
		array[count] = element;
		count++;
		printArray();
	}
	
	
	public void addAt(int index, int element) {
		if(size == count)
			growArray();

		for(int i = count-1; i>=index; i--)
			array[i+1] = array[i];

		array[index] = element;
		count++;
		printArray();
	}
	
	public void remove(int element) {
		int index = linearSearch(element);
		if (index == -1)
			System.out.println("Unable to find element");
		else
			removeAt(index);
	}

	public int linearSearch(int element) {
		int index = -1;
		for(int i=0;i<count; i++)
			if (array[i] == element)
				index = i;
		return index;
	}
	
	public void removeAt(int index) {
		for(int i=index; i<count;i++)
			array[i] = array[i+1];

        count--;
		array[count] = 0;
		if(count < size/2)
			shrinkSize();
		printArray();
	}
	
	public void shrinkSize() {
		int[] temp = Arrays.copyOf(array, size/2);
		array = temp;
		size = size/2;
	}
	
	public void growArray() {
		int[] temp = new int[2*size];
		for(int i=0;i<size; i++ ) {
			temp[i] = array[i];
		}
		//or
		//int[] temp = Arrays.copyOf(array, 2*size);
		array = temp;
		size = 2*size;
	}
	
	public static void main(String[] args) {
		DynamicArrays arr = new DynamicArrays(5);
		
		arr.add(5);
		arr.addAt(1,6);
		arr.addAt(2, 0);
		arr.add(4);
		arr.add(6);
		arr.add(7);
		arr.removeAt(2);
		arr.remove(4);
		arr.remove(8);
	}

	public void printArray() {
		System.out.println(Arrays.toString(array));
	}
}
