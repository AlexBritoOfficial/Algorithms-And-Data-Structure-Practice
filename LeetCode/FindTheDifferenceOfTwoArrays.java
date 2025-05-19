package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindTheDifferenceOfTwoArrays {

    /*** 2215. Find the Difference of Two Arrays
     *      Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
     *
     *      answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
     *      answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
     *      Note that the integers in the lists may be returned in any order.
     *
     * */


    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        int[] num2 = {2, 4, 6};

        System.out.println(FindTheDifferenceOfTwoArrays.findDifference(nums1, num2));

    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        // Range -1000 to 1000 --> offset by 1000 to use as index
        boolean[] nums1Presence = new boolean[2001];
        boolean[] nums2Presence = new boolean[2001];

        // Mark presence in nums1
        for (int num : nums1) {
            nums1Presence[num + 1000] = true;
        }

        // Mark presence in nums2
        for (int num : nums2) {
            nums2Presence[num + 1000] = true;
        }

        List<Integer> nums1Distinct = new ArrayList<>();
        List<Integer> nums2Distinct = new ArrayList<>();

        // Check which values exist in nums1 but not in nums2
        for (int i = 0; i < 2001; i++) {
            if (nums1Presence[i] && !nums2Presence[i]) {
                nums1Distinct.add(i - 1000);
            }
        }

        // Check which values exist in nums2 but not in nums1
        for (int i = 0; i < 2001; i++) {
            if (nums2Presence[i] && !nums1Presence[i]) {
                nums2Distinct.add(i - 1000);
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(nums1Distinct);
        answer.add(nums2Distinct);
        return answer;
    }
}
