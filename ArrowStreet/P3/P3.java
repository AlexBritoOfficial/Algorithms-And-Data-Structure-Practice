package ArrowStreet.P3;

import java.util.List;

public class P3 {


    public static void main(String[] args) {
        //doubleSize();
    }

    public static long doubleSize(List<Long> arr, long b) {

        for (int i = 0; i < arr.size() ; i++) {
            if(arr.get(i) == b){
                b = arr.get(i) * 2;
            }
        }
        return b;
    }
}
