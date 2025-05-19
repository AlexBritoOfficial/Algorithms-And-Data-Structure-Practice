package LeetCode;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

//        int[] array = {1,1,2};
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(removeDuplicates(array));
    }

    public static int removeDuplicates(int[] nums) {

        int k = 0;
        int insert = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                int swap = nums[i];
                nums[insert] = swap;
                insert++;
                k = insert;
            }

        }

        return k;
    }
}
