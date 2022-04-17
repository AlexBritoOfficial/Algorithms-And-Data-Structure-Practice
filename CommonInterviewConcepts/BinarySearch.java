package CommonInterviewConcepts;

public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {5, 7, 8, 15, 16, 19};
        System.out.println(binarySearch(array, 0, array.length - 1, 19));

    }

    public static int binarySearch(int[] array, int left, int right, int target) {

        if (right >= 1) {

            int midPoint = (right + left) / 2;

            if (array[midPoint] == target) {
                return midPoint;
            }

            if (array[midPoint] > target) {
                return binarySearch(array, 0, midPoint - 1, target);
            } else
                return binarySearch(array, midPoint + 1, array.length - 1, target);

        }

        return -1;
    }
}
