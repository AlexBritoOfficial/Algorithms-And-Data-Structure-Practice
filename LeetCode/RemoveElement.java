package LeetCode;

public class RemoveElement {


    public static void main(String[] args) {

        int[] arr = {3, 2, 2, 3};

        removeElement(arr, 3);

    }

    public static int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }

        }

        return k;
    }

}
