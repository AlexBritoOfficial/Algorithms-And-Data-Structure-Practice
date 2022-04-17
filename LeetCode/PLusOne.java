package LeetCode;

import java.util.Arrays;

public class PLusOne {

    public static void main(String[] args) {

        // Example 1
        int[] digits = {1,2,3};

        plusOne(digits);

    }

    public static int[] plusOne(int[] digits) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            stringBuilder.insert(i, digits[i]);
        }

        Integer integer = Integer.getInteger(stringBuilder.toString());

        return new int[4];
    }
}
