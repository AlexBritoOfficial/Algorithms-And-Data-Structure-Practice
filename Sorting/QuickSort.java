package Sorting;

public class QuickSort {

    public static void main(String[] args) {
        /*** Quick Sort ***/
//        int [] array = {5,2,9,3,8,4,0,1,7};
        int [] array = {5,2,4,6,1,3};
        System.out.print("Unsorted: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        quickSort(array);
        System.out.println();
        System.out.print("Sorted: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] insertionSort(int[] array){
        int [] arr = array;
        for (int i = 1; i < arr.length ; i++) {
            int key = arr[i];
            // Insert array[i] into the sorted sequence array[1...i-1]
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    public static void quickSort(int[] array) {
        quickSort(array,0,array.length - 1);
    }

    public static void quickSort(int[]array, int first, int last){
        if(last > first){
            int pivotIndex = partition(array,first,last);
            quickSort(array, first, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, last);
        }
    }

    private static int partition(int[] array, int first, int last) {
        // int [] array = {5,2,4,6,1,3};
        int pivot = array[first];
        int low = first + 1;
        int high = last;

        while(high > low){
            // Search forward from left.'
            while(low <= high && array[low] <= pivot){
                low++;
            }

            // Search backward from right
            while(low <= high && array[high] > pivot){
                high--;
            }

            // Swap two elements in the list
            if(high > low){
                int temp = array[high];
                array[high] = array[low];
                array[low] = temp;
            }
        }
        while(high > first && array[high] >= pivot){
            high--;
        }
        if(pivot > array[high]){
            array[first] = array[high];
            array[high] = pivot;
            return high;
        }
        else
            return first;
    }
}