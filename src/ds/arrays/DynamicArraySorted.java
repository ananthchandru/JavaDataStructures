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

        int index = findIndex(true, element, 0 ,count-1);
        for(int i=count-1; i>=index; i--)
            arr[i+1] = arr[i];
        arr[index] = element;
        count++;
    }

    public void remove(int element) {
        int index = findIndex(false, element, 0, count-1);
        removeAt(index);
    }

    public void removeAt(int index) {
        if(count > 0) {
            for(int i=index; i<count-1;i++)
                arr[i] = arr[i+1];
            count--;
            arr[count] = 0;

            if(count < size/2) {
                shrinkArray();
            }
        } else {
            System.out.println("Unable to remove. List is empty");
        }
    }

    public int findIndex(boolean isInsert, int element, int low, int high) {

        int mid = (high + low) / 2;

        //find index for insert
        if(isInsert) {
            //condition 1 => element might be 0 or be first insert
            if(element == 0 || count == 0 || element < arr[low])
                return 0;
            //condition 2 => element might be higher than high
            if(element > arr[high])
                return high+1;
            //condition 3 => between adjacent indices
            if (element > arr[mid] && element < arr[mid + 1])
                return mid + 1;
        }
        //condition 4 => element is equal to mid
        if(element == arr[mid])
            return mid;
        //condition 5 => element is less than mid
        if (element < arr[mid])
            return findIndex(isInsert, element, low, mid-1);
        //condition 6 => element is greater than mid
        return findIndex(isInsert, element, mid+1, high);
    }

    public void growArray() {
        size = 2 * size;
        int[] temp = Arrays.copyOf(arr, size);
        arr = temp;
    }

    public void shrinkArray() {
        size = size/2;
        int[] temp = Arrays.copyOf(arr, size);
        arr = temp;
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
}