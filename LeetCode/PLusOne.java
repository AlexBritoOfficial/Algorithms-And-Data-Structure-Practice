package LeetCode;

import java.util.Arrays;

public class PLusOne {

    public static void main(String[] args) {

        // Example 1
        int[] digits = {9, 9, 9};

        plusOne(digits);

    }


    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] == 9) {
                digits[i] = 0;
                continue;
            }

            else  {
                digits[i] = digits[i] + 1;
                break;
            }
        }

        if(digits[0] == 0){
            int [] arr = new int[digits.length + 1];
            arr[0] = 1;
            return arr;
        }

        return digits;
    }
}
