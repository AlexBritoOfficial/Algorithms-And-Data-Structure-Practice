package com.company.Sorting;

public class RadixSort {
    final static int BASE = 10;

    public static void main(String[] args) {
//        int[] array = {405, 199, 80, 403, 213, 312};
        int [] array = {1, 10, 100, 1000, 10000, 100000};
        array = radixSort(array);
        printArray(array);
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

    public static int[] radixSort(int[] array) {
        int max = getMax(array);

        for (int i = 1; max / i > 0; i *= BASE) {
            System.out.println(i);
            array = stableSort(array,i);
        }
        return array;
    }

    public static int[] stableSort(int[] array, int digit) {
        int count[] = new int[BASE];
        int pos[] = new int[BASE];
        int output[] = new int[array.length];

        for (int x : array) {
            count[getDigit(x, digit)]++;
        }
        for (int i = 1; i < pos.length; i++) {
            pos[i] = count[i - 1] + pos[i - 1];
        }

        for (int i = 0; i < array.length; i++) {
            output[pos[getDigit(array[i], digit)]] = array[i];
            pos[getDigit(array[i], digit)]++;
        }

        return output;
    }

    public static int getDigit(int number, int digit) {
        String numberString = String.valueOf(number);
        int position = ((numberString.length() - 1) - ((int) Math.log10(digit)));
        if(position < 0){
            return 0;
        }
        return Integer.parseInt(String.valueOf(numberString.charAt(position)));
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
