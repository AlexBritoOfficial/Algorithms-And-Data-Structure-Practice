package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    //  Given two strings s and t, return true if t is an anagram of s, and false otherwise.


    public static void main(String[] args) {

        // Test Case # 1
        // Input: s = "anagram", t = "nagaram"
        // Output: true

        //String s = "anagram";
        //String t = "nagaram";

        // Test Case # 2
        String s = "rat";
        String t = "car";

        System.out.println(isAnagram(s, t));

    }

    public static boolean isAnagram(String s, String t) {
        // Check if both Strings contain the same length.
        if (s.length() != t.length()) {
            return false;
        } else {
            // Populate HashMaps
            HashMap<Character, Integer> sHashMap = populateSHashMap(s);
            HashMap<Character, Integer> tHashMap = populateTHashMap(t);

            return checkAnagram(sHashMap, tHashMap);
        }
    }


    public static HashMap<Character, Integer> populateSHashMap(String s) {
        HashMap<Character, Integer> sHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if (!(sHashMap.containsKey(s.charAt(i)))) {
                sHashMap.put(s.charAt(i), 1);
            } else {
                int sValue = sHashMap.get(s.charAt(i));
                sHashMap.put(s.charAt(i), ++sValue);
            }
        }
        return sHashMap;
    }


    public static HashMap<Character, Integer> populateTHashMap(String t) {
        HashMap<Character, Integer> tHashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {

            if (!(tHashMap.containsKey(t.charAt(i)))) {
                tHashMap.put(t.charAt(i), 1);
            } else {
                int tValue = tHashMap.get(t.charAt(i));
                tHashMap.put(t.charAt(i), ++tValue);
            }
        }
        return tHashMap;
    }

    public static boolean checkAnagram(HashMap<Character, Integer> sHashMap, HashMap<Character, Integer> tHashMap) {

        for (Map.Entry<Character, Integer> entrySet : sHashMap.entrySet()) {
            if (tHashMap.containsKey(entrySet.getKey()) && tHashMap.get(entrySet.getKey()).equals(entrySet.getValue())) {
                continue;
            } else
                return false;
        }
        return true;
    }
}

