package Sorting;

public class QuickSortThomasCormen {

    public static void main(String[] args) {
        int[] array = {2,8,7,1,3,5,6,4};
        quickSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static void quickSort(int [] array, int first, int last){

        if(first < last){
            int pivotIndex = partition(array, first, last);
            quickSort(array, first, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, last);
        }

    }

    public static int partition(int [] array, int first, int last){
        int pivot = array[last];
        int lowPointer = first - 1;

        for (int j = first; j < last ; j++) {
            if(array[j] <= pivot) {
                lowPointer = lowPointer + 1;

                // Exchange array[lowPointer] with array[j]
                int temp = array[lowPointer];
                array[lowPointer] = array[j];
                array[j] = temp;
            }
        }
        // Exchange array[lowPointer + 1 ] with array[last]
        int secondTemp = array[last];
        array[last] = array[lowPointer + 1];
        array[lowPointer + 1] = secondTemp;
        return lowPointer + 1;
    }
}
