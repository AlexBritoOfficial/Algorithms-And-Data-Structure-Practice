package LeetCode;

import java.util.*;
// NOT SOLVED ON MY OWN !!!

public class LongestCommonPrefix {

    /***
     *      Write a function to find the longest common prefix string amongst an array of strings.

     If there is no common prefix, return an empty string "".

     Example 1:

     Input: string = ["flower","flow","flight"]
     Output: "fl"

     Example 2:

     Input: string = ["dog","racecar","car"]
     Output: ""
     Explanation: There is no common prefix among the input strings.

     Constraints:

     1 <= string.length <= 200
     0 <= string[i].length <= 200
     string[i] consists of only lower-case English letters.
     ****/


    public static void main(String[] args) {
        //String[] strings = {"flower", "flow", "flight"};
        //String[] strings = {"ab", "a"};
        //String[] strings = {"cir", "car"};
        //String[] strings = {"caa", "", "a", "acb"};
        String[] strings = {"caa", "", "a", "acb"};
        //String[] strings = {"cc", "cc"};

        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length())
        {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);
    }
    public static int returnShortestString(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return s2.length();
        } else if (s1.length() < s2.length()) {
            return s1.length();
        } else
            return s1.length();
    }

//    public static String longestCommonPrefix(String[] strings) {
//
//
//
//        for (int i = 0; i < strings.length ; i++) {
//
//        }
//
//        return "";
//    }
}
