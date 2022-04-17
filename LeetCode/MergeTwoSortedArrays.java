package LeetCode;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {

        // Arrays
        // Test Case # 1
        // int[] nums1 = {1, 2, 3, 0, 0, 0};
        // int[] nums2 = {2, 5, 6};

         // Test Case # 2
         int[] nums1 = {4, 5, 6, 0, 0, 0};
         int[] nums2 = {1, 2, 3};

//        // Test Case # 3
//        int[] nums1 = {2, 0};
//        int[] nums2 = {1};

        // The number of available slots in the nums1 is given by m
        int m = nums2.length;

        // The number of elements to be inserted into nums1
        int n = nums2.length;

        // Function
        merge(nums1, m, nums2, n);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int p = 0;
        for (int i = m; i < nums1.length ; i++) {
            nums1[m] = nums2[p];
            p++;
        }
        Arrays.sort(nums1);
    }
}

