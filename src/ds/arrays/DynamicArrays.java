package ds.arrays;


//First we need members and constructors to initialise the array.
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
		
		arr.add(5);
		System.out.println(arr.size);
		arr.add(6);
		System.out.println(arr.size);
		arr.add(7);
		System.out.println(arr.size);
	}

}
