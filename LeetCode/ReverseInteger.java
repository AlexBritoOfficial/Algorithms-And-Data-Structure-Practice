package LeetCode;

import java.util.Stack;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = -123;

        System.out.println(reverse(
                1534236469));

    }


//    public static int reverse(int x) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        if(x == 0){
//            return 0;
//        }
//
//        else if (Integer.toString(x).length() == 1){
//            return x;
//        }
//
//        else {
//            Stack<Character> myStack = new Stack<>();
//
//            for (int i = 0; i < Integer.toString(x).length() ; i++) {
//                myStack.push(Integer.toString(x).charAt(i));
//            }
//
//            while(!myStack.empty()){
//                Character character = myStack.pop();
//                if(character == '-'){
//                    stringBuilder.insert(0,character);
//                    try{
//                        int reverse =  Integer.valueOf(stringBuilder.toString());
//                    } catch (NumberFormatException exception) {
//                        return 0;
//                    }
//                    return Integer.parseInt(stringBuilder.toString());
//                }
//                stringBuilder.append(character);
//            }
//
//        }
//
//        try{
//           int reverse =  Integer.valueOf(stringBuilder.toString());
//
//          } catch (NumberFormatException exception) {
//            return 0;
//        }
//
//        return Integer.parseInt(stringBuilder.toString());
//    }

    public static int reverse(int x){
        if(x == 0){
            return 0;
        }

        else if (Integer.toString(x).length() == 1){
            return x;
        }

        StringBuilder stringBuilder = new StringBuilder(Integer.toString(x)).reverse();
        try{
            if (stringBuilder.toString().charAt(stringBuilder.length() - 1) == '-'){
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                stringBuilder.insert(0, '-');
            }

            return Integer.parseInt(stringBuilder.toString());

        } catch (NumberFormatException exception){
            return 0;
        }
    }
}
