package ds.arrays;

import java.util.Arrays;

public class DynamicArraySorted {
    private int[] arr;
    private int size, count;

    public DynamicArraySorted(int size) {
        this.size = size;
        arr = new int[size];
        count=0;
    }

    public void add(int element) {
        if(size==count)
            growArray();

        int index = -1;
        //condition 1 => element must be lower than all other elements
        if(count == 0 || element <= arr[0])
            index =0;
       //condition 2 => element is highest than all other elements
        else if (element >= arr[count-1])
            index = count;
        //condition 3 => element must be within low and high
        else
            index = binarySearch(true, element, 0 ,count-1);

        for(int i=count-1; i>=index; i--)
            arr[i+1] = arr[i];
        arr[index] = element;
        count++;

        printArray();
    }

    public void remove(int element) {
        int index = binarySearch(false, element, 0, count-1);
        if(index == -1)
            System.out.println("Unable to find element");
        else
            removeAt(index);
    }

    public void removeAt(int index) {
        for(int i=index; i<count-1;i++)
            arr[i] = arr[i+1];
        count--;
        arr[count] = 0;

        if(count < size/2)
            shrinkArray();
        printArray();
    }

    public int binarySearch(boolean isInsert, int element, int low, int high) {
            int mid = (high + low) / 2;
            //condition 4 => element is equal to mid
            if (element == arr[mid])
                return mid;
            //condition 5 => between adjacent indices
            if (isInsert && element > arr[mid] && element < arr[mid + 1])
                return mid + 1;
            //condition 6 => element is less than mid
            if (element < arr[mid])
                return binarySearch(isInsert, element, low, mid - 1);
            //condition 7 => element is greater than mid
            return binarySearch(isInsert, element, mid + 1, high);
    }

    public void growArray() {
        int[] temp = Arrays.copyOf(arr, size*2);
        arr = temp;
        size = 2 * size;
    }

    public void shrinkArray() {
        int[] temp = Arrays.copyOf(arr, size/2);
        arr = temp;
        size = size/2;
    }

    public static void main(String[] args) {
        DynamicArraySorted array = new DynamicArraySorted(1);
        array.add(3);
        array.add(1);
        array.add(5);
        array.add(7);
        array.remove(3);
        array.removeAt(1);
        array.remove(7);
    }

    public void printArray() {
        System.out.println(Arrays.toString(arr));
    }
}