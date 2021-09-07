package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {

        String romanNumeral = "IV";
        //String romanNumeral = "IX";
        //String romanNumeral = "III";
        //String romanNumeral = "LVIII";
        //String romanNumeral = "LVIII";
        //String romanNumeral = "MCMXCIV";
        //String romanNumeral = "CMLII"; // 952

        System.out.println(romanToInt(romanNumeral));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> hashMap = new LinkedHashMap<>();
        char[] romanSymbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] romanValues = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < romanSymbols.length; i++) {
            hashMap.put(romanSymbols[i], romanValues[i]);
        }

        if(s.length() == 1){
            return hashMap.get(s.charAt(0));
        }

        int sum = 0;
        int pointer = s.length() - 1;
        while (pointer > 0) {
            if (hashMap.get(s.charAt(pointer)).compareTo(hashMap.get(s.charAt(pointer - 1))) > 0) {
                int difference = hashMap.get(s.charAt(pointer)) - hashMap.get(s.charAt(pointer - 1));
                sum += difference;
                pointer -= 2;
            } else {
                sum += hashMap.get(s.charAt(pointer));
                pointer--;
            }

            if(pointer == 0){
                sum += hashMap.get(s.charAt(pointer));
                break;
            }
        }
        return sum;
    }
}