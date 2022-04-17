package LeetCode;

import java.util.HashMap;

public class Atl {
    public static void main(String[] args) {

        System.out.println(convert(7));

    }


    public static String convert (int x) {

        if(x == 0){
            return Integer.toString(x);
        }

        char[] characters = {'0', 'a', 't', 'l','s','i','n'};

        char r =  characters [x%7];
        int q = x / 7;
        return (convert(q)) + r;
    }

    public static String convert2(String string){

        HashMap<Integer, Character> hashMap = new HashMap<>();
        char[] characters = {'0', 'a', 't', 'l','s','i','n'};
        StringBuilder stringBuilder = new StringBuilder();


        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(characters[string.charAt(i)]);
        }

        return "";
    }
}
