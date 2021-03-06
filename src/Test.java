import java.util.Arrays;
import java.util.Random;

class Test {

    public static void main(String[] args) {
        int[] arr = {10,4,2,8,5,1,9,7,6};
        Test obj = new Test();
        System.out.println(Arrays.toString(arr));
        obj.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr) {
        quickSortRec(arr, 0, arr.length-1);
    }

    public void quickSortRec(int[] arr, int low, int high) {
        System.out.println("quickSort: " + low + ", " + high);
        if(low < high) {
            int mid = findPartition(arr, low, high);
            System.out.println("mid: " + mid);
            quickSortRec(arr, low, mid-1);
            quickSortRec(arr, mid+1, high);
        }
    }

    public int findPartition(int[] arr, int low, int high) {

        Random random = new Random();
        //nextInt will include 0 but exclude the specified number
        //nextInt(9) will generate  0 to 8, so +1 is added
        int randomInt = low + random.nextInt(high-low+1);
        swap(arr, high, randomInt);

        int pivot = arr[high];

        while(true) {
            while(arr[low] < pivot)
                low++;
            while(arr[high] > pivot)
                high--;
            if(low < high)
                swap(arr, low, high);
            else
                return high; //as low and high must have crossed each other by 1 position
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}