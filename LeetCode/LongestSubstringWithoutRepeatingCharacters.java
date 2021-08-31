package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {


        /**
         * Given a string s, find the length of the longest substring without repeating characters.
         **/
        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("brnk"));
    }



    private static int lengthOfLongestSubstring(String s) {

        HashSet<Character> hashSet = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;

            while (j < s.length()){
                if(!hashSet.contains(s.charAt(j))){
                    hashSet.add(s.charAt(j));
                    max = Math.max(hashSet.size(), max);
                }
                else{
                    hashSet.remove(i);
                    i++;
                }
            }
        return max;
    }


}
