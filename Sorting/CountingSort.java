package Sorting;

import jdk.jfr.Unsigned;

public class CountingSort {

    public final static int MAX_INPUT = 262143;

    public static void main(String[] args) {
//        int[] array = {1, 10, 100, 1000, 10000, 1000000};
        int[] array = {9999, 10000};
        int[] out = new int[array.length];
        out = countSort(array);

        for (int i = 0; i < out.length; i++) {
            System.out.print(out[i] + " ");
        }
    }

    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int[] countSort(int[] arr) {
        int n = arr.length;

        final int MAX = getMax(arr);

        // The output character array that will have sorted arr
        int output[] = new int[n];

        // Create a count array to store count of individual
        // characters and initialize count array as 0
        int count[] = new int[100000];
        for (int i = 0; i < count.length; i++)
            count[i] = 0;

        // store count of each character
        for (int i = 0; i < n; i++)
            count[arr[i]]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        return output;
    }
}
