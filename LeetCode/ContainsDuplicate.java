package LeetCode;

import java.util.*;

public class ContainsDuplicate {

    // 217. Contains Duplicate
    // Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    // Example 1
    // Input: nums = [1,2,3,1]
    // Output: true

    public static void main(String[] args) {

    }

    public static boolean containsDuplicates(int[] nums) {
        Set<Integer> linkedHashSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!linkedHashSet.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
