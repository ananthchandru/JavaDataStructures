import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,1,2,3};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swap = false;
        while(n>0) {
            swap = false;
            for(int i=0; i<n-1;i++) {
                if(arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    swap = true;
                }
            }
            if(!swap)
                break;
            n--;
        }

    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}