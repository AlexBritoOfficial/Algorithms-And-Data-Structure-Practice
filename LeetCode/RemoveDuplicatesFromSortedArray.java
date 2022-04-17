package LeetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] array = {0,0,1,1,1,2,2,3,3,4};

        removeDuplicates(array);
    }

//    public static int removeDuplicates(int[] nums) {
//
//        Set<Integer> hashSet = new HashSet<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            hashSet.add(nums[i]);
//        }
//
//        Object[] object = hashSet.toArray();
//
//        return object.length;
//    }

    public static int removeDuplicates(int[] nums) {

        int p = 0;
        int q = p + 1;
        while(q < nums.length){

            if(nums[p] == nums[q]){
                q++;
            }

            else {
                p++;
                nums[p] = nums[q];
            }
        }

        return p;
    }
}
