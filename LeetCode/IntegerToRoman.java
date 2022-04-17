package LeetCode;

import javax.security.auth.callback.CallbackHandler;
import java.util.*;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }

    public static String intToRoman(int num) {

        Character[] romanNumerals = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        HashMap<Integer, Integer> hashMapLinkedHashMap = new LinkedHashMap<>();
        HashMap<Integer, Character> evenHashMapLinkedHashMap = new LinkedHashMap<>();
        HashMap<Integer, Character> oddHashMapLinkedHashMap = new LinkedHashMap<>();

        for (int i = 0; i < romanNumerals.length; i++) {

            if (i % 2 == 0) {
                hashMapLinkedHashMap.put(i, (int) Math.pow(10, i / 2));
                evenHashMapLinkedHashMap.put((int) Math.pow(10, i / 2), romanNumerals[i]);
            } else {
                hashMapLinkedHashMap.put(i, hashMapLinkedHashMap.get(i - 1) * 5);
                oddHashMapLinkedHashMap.put(hashMapLinkedHashMap.get(i - 1) * 5, romanNumerals[i]);
            }
        }

        oddHashMapLinkedHashMap.put(1000, 'M');

        return intToRomanHelper(num, new StringBuilder(), evenHashMapLinkedHashMap, oddHashMapLinkedHashMap);
    }

    // Working Solution # 1
    public static String intToRomanHelper(int num, StringBuilder stringBuilder, HashMap<Integer, Character> evenHashMapLinkedHashMap, HashMap<Integer, Character> oddHashMapLinkedHashMap) {

        if (num == 0) {
            return stringBuilder.toString();
        }

        int onesTenthsHundredsThousandths = getOnesTensHundrethsThousandths(num);
        int originalNum = num;
        num = Character.getNumericValue(String.valueOf(num).charAt(0)) * onesTenthsHundredsThousandths;

        while (num >= onesTenthsHundredsThousandths) {

            if (oddHashMapLinkedHashMap.containsKey(num)) {
                stringBuilder.append(oddHashMapLinkedHashMap.get(num));
                break;
            }

            if (num == onesTenthsHundredsThousandths * 4) {
                stringBuilder.append(evenHashMapLinkedHashMap.get(onesTenthsHundredsThousandths));
                stringBuilder.append(oddHashMapLinkedHashMap.get(onesTenthsHundredsThousandths * 5));
                break;
            } else if (num == onesTenthsHundredsThousandths * 9) {
                stringBuilder.append(evenHashMapLinkedHashMap.get(onesTenthsHundredsThousandths));
                stringBuilder.append(evenHashMapLinkedHashMap.get((int) Math.pow(10, String.valueOf(num).length())));
                break;
            } else if (num < onesTenthsHundredsThousandths * 9 && num > onesTenthsHundredsThousandths * 5) {
                stringBuilder.append(oddHashMapLinkedHashMap.get(onesTenthsHundredsThousandths * 5));
                num -= (onesTenthsHundredsThousandths * 5);
                continue;
            } else {
                stringBuilder.append(evenHashMapLinkedHashMap.get(onesTenthsHundredsThousandths));
                num -= (onesTenthsHundredsThousandths);
                continue;
            }
        }

        intToRomanHelper(originalNum % onesTenthsHundredsThousandths, stringBuilder, evenHashMapLinkedHashMap, oddHashMapLinkedHashMap);

        return stringBuilder.toString();
    }

    public static int getOnesTensHundrethsThousandths(int num) {
        return (int) Math.pow(10, Integer.toString(num).length() - 1);
    }
}
