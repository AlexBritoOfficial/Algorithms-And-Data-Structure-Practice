package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLastWord {


    // Test Case # 1
    // Input: s = "Hello World"

    public static void main(String[] args) {

        String s = "Hello World";

        lengthOfLastWord(s);
    }

    public static int lengthOfLastWord(String s) {

        // Split Array white space
        String[] splitArray = s.split(" ");

        return splitArray[splitArray.length - 1].length();
    }
}
