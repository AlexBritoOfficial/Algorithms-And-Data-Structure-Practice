package PaulMocks;

public class Question1 {


    /***
     * Given a sorted array and an element. Insert element into its correct position in the array.
     ****/
    public static void main(String[] args) {
        int [] array = {1,2,4,5,7,9};
        sort(array, 6);

    }

    public static void sort (int [] array, int element){
        boolean inserted = false;
        int [] newArray = new int[array.length + 1];

        //for (int i = 0; i < newArray.length; i++) {
        for (int i = 0; i < array.length; i++) {

        if(inserted){
                newArray[i + 1] = array[i];
                break;
            }
            if(array[i] < element){
                newArray[i] = array[i];
            }

            else if (array[i] > element) {
                newArray[i] = element;
                newArray[i + 1] = array[i];
                inserted = true;
            }

        }

        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
}
