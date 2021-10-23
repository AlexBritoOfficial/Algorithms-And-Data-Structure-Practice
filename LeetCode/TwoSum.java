package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static void main(String[] args) {
        // 9
        // Wrapper classes provide a way to use primitive data types ( int , boolean , etc..) as objects
        // Map Key Value -> Keys: States in the US, Values : Capital of the State

        // A Generic class simply means that the items or functions in that class can be generalized with the
        // parameter (example T) to specify that we can add any type as a parameter in place of T like Integer, Character, String, Double
        // or any other user-defined type.

        HashMap<String, String> statesAndCapitals = new HashMap<>();

        int[] nums = {11, 7, 2, 15};
        int[] array = twoSum(nums, 9);
        System.out.println("[" + array[0] + "," + array[1] + "]");
    }

    public static int[] twoSum(int[] nums, int target) {

        // {11,7,2,15};

        // Target 9

        // i  = 0
        // 9 - 11 = -2
        // HashMap = []

        // i = 1
        // 9 - 7 = 2
        // nums[i] = 7
        // 7 is not greater than 2
        // put 7 in map
        // Complement = 2

        // i =

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (!hashMap.containsKey(complement)) {
                hashMap.put(nums[i], i);
            } else if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            }
        }

        return new int[2];
    }
}
