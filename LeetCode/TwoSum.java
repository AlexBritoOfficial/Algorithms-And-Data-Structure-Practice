package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11};

        twoSum(nums, 10);
    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target && (i != j)) {
                    int[] array = {i, j};
                    return array;
                }
            }
        }

        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < nums.length ; i++) {
            if(!(myMap).containsKey(target - nums[i])){

            }
        }
        return null;
    }
}
