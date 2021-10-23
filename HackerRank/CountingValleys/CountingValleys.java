package HackerRank.CountingValleys;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class CountingValleys {

    public static void main(String[] args) {

        // Test Case 1
        // 8
        // UDDDUDUU

        // int numberOfSteps = 8;
        // String steps = "UDDDUDUU";

        // Test Case 2
        // 12
        // DDUUDDUDUUUD

        int numberOfSteps = 12;
        String steps = "DDUUDDUDUUUD";

        System.out.println(countingValleys(numberOfSteps, steps));

    }

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    // Write your code here
    public static int countingValleys(int steps, String path) {
        return insertCharactersIntoStack(0, path.length(), path);
    }

    public static int insertCharactersIntoStack(int start, int end, String path) {
        Stack<Character> stack = new Stack<>();

        // _    _      _/\_
        //  \  / \    /
        //   \/   \/\/

        int counter = 0;

        for (int i = start; i < end ; i++) {

            if (stack.contains('U') && path.charAt(i) == 'D'){
                stack.pop();
                continue;
            }

            else if (stack.contains('D') && path.charAt(i) == 'U' ){
                stack.pop();
                if(stack.size() == 0){
                    counter++;
                }
                continue;
            }

            stack.push(path.charAt(i));

            if(stack.size() > 10000){
                return 1;
            }
        }

        return counter;
    }
}
