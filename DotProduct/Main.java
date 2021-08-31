package DotProduct;

public class Main {

    public static void main(String[] args) {

        int n = 5;
        int vector [] = new int [n];
        int resultVector [] = new int [n];
        int [][]  myMatrix= new int[n][n];
        for (int i = 0; i < n; i++) {
            vector[i] = 1;
            for (int j = 0; j < n ; j++) {
                if (i == j){
                    myMatrix[i][j]  = 2;
                }
                else if (i == j - 1){
                    myMatrix[j-1][j]  = 1;
                }
                else if (i == j + 1) {
                    myMatrix[j + 1][j] = 1;
                }
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    resultVector[i] = (vector[i] + ( myMatrix[i][j] * myMatrix[j+1][j]));
                }

                else if(i == 4 && j == 4){
                    resultVector[i] = (vector[i] * ( myMatrix[i][j] + myMatrix[j - 1][j]));
                }

                else if (i == j) {
                    resultVector[i] = (vector[i] * ( myMatrix[i][j] + myMatrix[j - 1][j] + myMatrix[j + 1][j]));
                }

            }
        }

    }
}
