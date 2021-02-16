package com.company.RobinHood;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P4 {
    public static void main(String[] args) {
        int[] a = {3, 2, -1, 4};
        char[] signs = {'+', '-', '-', '+'};
        int[] b = {2, 7, -5, 2};
        int[] c = {5, 5, 4, 2};
        boolean[] outCome = new boolean[a.length];

        for (int i = 0; i < signs.length; i++) {
            switch (signs[i]) {
                case '+':
                    outCome[i] = add(a[i], b[i], c[i]);
                    break;
                case '-':
                    if (b[i] < 0) {
                        b[i] = Math.abs(b[i]);
                        outCome[i] = add(a[i], b[i], c[i]);
                        break;
                    } else
                        outCome[i] = subtract(a[i], b[i], c[i]);
                    break;
            }
        }
    }

    public static boolean add(int a, int b, int c) {
        int result = a + b;
        System.out.printf("%d  +  %d ", a, b);
        if (result != c) {
            return false;
        } else
            return true;
    }

    public static boolean subtract(int a, int b, int c) {
        int result = a - b;
        System.out.printf("%d  +  %d ", a, b);
        if (result != c) {
            return false;
        } else
            return true;
    }
}
