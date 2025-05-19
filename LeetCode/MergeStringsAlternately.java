package LeetCode;

public class MergeStringsAlternately {

    /**
     * 1768. Merge Strings Alternately
     * a   b   c
     * ^
     * p
     * <p>
     * p   q   r   s
     * ^
     * q
     * <p>
     * a p
     * p q + 1
     */


    public static void main(String[] args) {

        String word1 = "ab";
        String word2 = "pqrs";

        System.out.println(MergeStringsAlternately.mergeAlternately(word1, word2));

    }

    public static String mergeAlternately(String word1, String word2) {

        StringBuilder merged = new StringBuilder();
        int p1 = 0;
        int p2 = 0;

        while (p1 < word1.length() || p2 < word2.length()) {

            if(p1 < word1.length()){
                merged.append(word1.charAt(p1));
                p1++;
            }

            if(p2 < word2.length()){
                merged.append(word2.charAt(p2));
                p2++;
            }
        }

        return merged.toString();
    }
}
