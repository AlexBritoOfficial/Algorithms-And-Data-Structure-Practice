package ArrowStreet.P2;

import java.util.*;

public class P2 {
    public static void main(String[] args) {

        List<String> string = Arrays.asList("code","aaagmnrs","anagrams","doce");

        String text = "text";
       // Iterator iterator = text.toCharArray();

        funWithAnagrams(string);
    }

    public static List<String> funWithAnagrams(List<String> text) {

        // ["code","aaagmnrs","anagrams","doce"]


        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();

        for (String string: text) {
            Iterator iterator = text.iterator();
            while(iterator.hasNext()){
    //            hashMap1.put(iterator.next(), 1);

            }
        }

        return text;
    }

    public static boolean checkLength(String s1, String s2){



        return true;
    }
}
