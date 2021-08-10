package ds.arrays;


import java.util.Arrays;

//First we need members and constructors to initialise the array.
//reference - https://www.geeksforgeeks.org/how-do-dynamic-arrays-work/
public class DynamicArrays {
	
	private int[] array;
	private int size;
	private int count;
	
	public DynamicArrays() {
		array = new int[1];
		size = 1;
		count = 0;
	}
	
	public void add(int element) {
		if(size == count) {
			growArray();
		}
		array[count] = element;
		count++;
	}
	
	
	public void addAt(int index, int element) {
		if(size == count) {
			growArray();
		}
		for(int i= count-1; i>index; i--) {
			array[i+1] = array[i];
		}
		array[index] = element;
		count++;
	}
	
	public void remove() {
		if(count > 0) {
            count--;
			array[count] = 0;
		}
	}
	
	public void removeAt(int index) {
		for(int i=index; i<count;i++) {
			array[i] = array[i+1];
		}
        count--;
		array[count] = 0;
	}
	
	public void shrinkSize() {
		if(count > 0) {
			int temp[] = Arrays.copyOf(array, count);
			array = temp;
			size = count;
		}
	}
	
	public void growArray() {
		int temp[] = new int[2*size];
		for(int i=0;i<size; i++ ) {
			temp[i] = array[i];
		}
		array = temp;
		size = 2*size;
	}
	
	public static void main(String[] args) {
		DynamicArrays arr = new DynamicArrays();
//		
//		int[] array = new int[100];
//		System.out.println(array.length);
//		int[] newArray = new int[2];
//		array = newArray;
//		System.out.println(array.length);
		
		arr.add(5);
		System.out.println(arr.size);
		arr.addAt(1,6);
		System.out.println(arr.size);
		arr.addAt(2, 0);
		System.out.println(arr.size);
		arr.add(4);
		arr.add(6);
		arr.add(7);
		System.out.println(arr.size);
		arr.removeAt(2);
		arr.remove();
		arr.shrinkSize();
		System.out.println(arr.size);
		arr.shrinkSize();
		System.out.println(arr.size);
	}

}
