import java.util.HashMap;

public class MBTA {

    public static void main(String[] args) {

        int [] list = {4,6,2, 3, 9};
        System.out.println(lowestOddNumber(list));

    }


    // Write a function that takes a string and returns the occurrence for each character
    // Write a function that takes a list of integers and returns the lowest odd value

    public static int lowestOddNumber(int[] list){

        Integer output = null;

        for (int i = 0; i < list.length; i++) {
            if(list[i] % 2 == 0){
                continue;
            }

            if (output == null || list[i] < output){
                output = list[i];
            }
        }

        return output;
    }


    public  HashMap<Character, Integer> numberOfOccurrences(String string){
        HashMap<Character, Integer> myMap = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {

            if(!(myMap.containsKey(string.charAt(i)))){
                myMap.put(string.charAt(i), 1);
            }

            else {
                int currentCount = myMap.get(string.charAt(i));
                myMap.put(string.charAt(i), currentCount + 1);
            }
        }

        return myMap;
    }
}
