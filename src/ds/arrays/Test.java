//dynamic array - unsorted

//functionlities
// insert, insertAt, remove, removeAt, grow, shrink
package ds.arrays;
import java.util.Arrays;

class Test {

    private int[] arr;
    private int size;
    private int counter;

    public Test(int size) {
        this.size = size;
        this.arr = new int[size];
        this.counter = 0;
    }

    public void printArray() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Test dynamicArray = new Test(3);
        dynamicArray.insert(5);
        dynamicArray.insertAt(1, 1);
        dynamicArray.insertAt(2, 2);
        dynamicArray.insert(4);
        dynamicArray.remove(2);
        dynamicArray.removeAt(0);
    }

    public void insert(int element) {
        if(size == counter)
            growArray();

        arr[counter] = element;
        counter++;
        printArray();
    }

    public void insertAt(int index, int element) {
        if(size == counter)
            growArray();

        for(int i=counter-1; i>=index; i--)
            arr[i+1]= arr[i];

        arr[index] = element;
        counter++;
        printArray();
    }

    public void remove(int element) {
        int index = getIndex(element);
        if(index ==1)
            System.out.println("Item to be deleted is not found");
        else
            removeAt(index);
    }

    public int getIndex(int element) {
        int index = -1;
        for(int i=0;i<counter-1; i++)
            if(arr[i] == element)
                index = i;
        return index;
    }

    public void removeAt(int index) {
        for(int i=index; i<counter-1;i++)
            arr[i] = arr[i+1];
        counter--;

        if(counter < size/2)
            shrinkArray();

        printArray();
    }

    public void growArray() {
        int[] temp = new int[size*2];
        for(int i=0; i<counter;i++)
            temp[i] = arr[i];

        arr = temp;
        size = size*2;

        printArray();
    }

    public void shrinkArray() {
        int[] temp = new int[size/2];
        for(int i=0; i<counter;i++)
            temp[i] = arr[i];
        arr = temp;
        size = size/2;

        printArray();
    }
}