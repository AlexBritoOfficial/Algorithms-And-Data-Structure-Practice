package LeetCode;

public class isPalindrome {
    public static void main(String[] args) {

        int x = 121;

        System.out.println(isPalindrome(x));
    }
    public static boolean isPalindrome(int x) {

        String xString = String.valueOf(x);
        int leftPointer = 0;
        int rightPointer = xString.length() - 1;

        while(leftPointer < rightPointer){
            if(xString.charAt(leftPointer) == xString.charAt(rightPointer)){
                leftPointer++;
                rightPointer--;
            }
            else
                return false;
        }

        return true;
    }

}
