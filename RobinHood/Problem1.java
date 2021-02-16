package com.company.RobinHood;

public class Problem1 {

    /*******
     *
     * You are given two arrays of integers a and b of the same length, and an integer k.
     * We will be iterating through array a from left to right, and simultaneously through array b from right to left,
     * and looking at pairs (x, y), where x is from a and y is from b. Such a pair is called tiny if the concatenation xy
     * is strictly less than k.
     *
     * Your task is to return the number of tiny pairs that you'll encounter during the simultaneous iteration through a and b.
     *
     *
     * ******/
    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        int k = 31;

        countTinyPairs(a,b,31);

    }

    public static int countTinyPairs(int[] a, int[] b, int k) {
        int tinyPairs = 0;
        int count = a.length - 1;
        for (int i = 0; i < a.length ; i++) {
            StringBuilder myString = new StringBuilder();
            myString.append(a[i]);
            myString.append(b[count]);
            myString.toString();
            count--;
            if(isTinyPair(myString,k)){
                tinyPairs++;
            }
        }
        return tinyPairs;
    }

    public static boolean isTinyPair(StringBuilder concat, int k){
        int concatInt = Integer.parseInt(concat.toString());
        if(concatInt < k){
            return true;
        }
        else
            return false;
    }
}
