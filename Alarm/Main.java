package Alarm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        int[] array = {4, 7, 7};

        System.out.println(getCost(array));
    }


    public static long getCost(int[] array) {

        var arraylist = makeIntegerArrayList(array);

        int currentCost = 0;

        for (int i = 0; i < arraylist.size() - i; i++) {
            for (int j = i + 1; j < arraylist.size() - 1; j++) {
                currentCost += Math.pow((arraylist.get(j) - arraylist.get(i)), 2);
            }
        }

        return currentCost;
    }

    long getMinimumCost(int[] array) {

        return 0;
    }

    public static ArrayList<Integer> makeIntegerArrayList(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            arrayList.add(new Integer(array[i]));
        }

        return arrayList;
    }
    public static ArrayList<Integer> insertElementIntoArrayList(ArrayList<Integer> arrayList, int element) {

        ArrayList<Integer> newArrayList = new ArrayList<>();
        List<Integer> otherHalf = arrayList.subList(1, arrayList.size());

        return null;
    }
}
