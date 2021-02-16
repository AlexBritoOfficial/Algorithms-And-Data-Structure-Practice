package com.company.RobinHood;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class P3 {
    public static void main(String[] args) {
        int[][] array = {
                {3, 5}, // 0
                {5, 1}, // 1
                {1, 4}, // 2
                {4, 2} // 3
        };

        restoreArray(array);
    }

    public static int[] restoreArray(int[][] pairs) {
        int[] fixed = new int[pairs.length + 1];
        for (int i = 0; i < pairs.length; i++) {
            for (int j = i + 1; j < fixed.length ; j++) {
                if(pairs[i][0] != pairs[j][0] && pairs[i][1] != pairs[j][1] ) {
                    fixed[i] = pairs[i][0];
                    fixed[j] = pairs[i][1];
                    break;
                }
            }
        }

        return fixed;
    }
}
