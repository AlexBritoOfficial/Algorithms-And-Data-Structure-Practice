package LeetCode;

import javax.script.AbstractScriptEngine;
import java.util.*;

public class AddBinary {


    /***
     * Example 1
     * * * Input: a = "11", b = "1"
     * Output: "100"
     *
     * 11
     * 10
     *
     ***/
    public static void main(String[] args) {

        // String a = "11";
        // String b = "1";

        String a = "1010";
        String b = "1011";

        //String a = "0";
        //String b = "0";

        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {

        StringBuilder stringBuilderA = new StringBuilder(a);
        StringBuilder stringBuilderB = new StringBuilder(b);
        StringBuilder resultStringBuilder = new StringBuilder();
        boolean carry = false;

        // Construct StringBuilder objects for both Strings. This will ensure both strings have the same length.
        if (getBiggerString(a, b).equals(a)) {
            for (int i = 0; i < a.length() - b.length(); i++) {
                stringBuilderB.insert(i, "0");
            }
        } else {
            for (int i = 0; i < b.length() - a.length(); i++) {
                stringBuilderA.insert(i, "0");
            }
        }

        for (int i = stringBuilderA.length() - 1; i >= 0; i--) {

            int result = Character.getNumericValue(stringBuilderA.charAt(i)) + Character.getNumericValue(stringBuilderB.charAt(i));

            if (carry == true) {
                result = result + 1;
                carry = false;
            }

            if (result == 0) {
                resultStringBuilder.insert(0, '0');
            } else if (result == 1) {
                resultStringBuilder.insert(0, '1');
            } else if (result == 2) {
                carry = true;
                resultStringBuilder.insert(0, '0');
            } else {
                carry = true;
                resultStringBuilder.insert(0, '1');
            }
        }

        if (carry == true) {
            resultStringBuilder.insert(0, "1");
        }

        return resultStringBuilder.toString();
    }

    // This function return the bigger string among the two strings passed into the arguments
    public static String getBiggerString(String a, String b) {

        if (a.length() > b.length()) {
            return a;
        } else
            return b;
    }

}
