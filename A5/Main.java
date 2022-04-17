package A5;

public class Main {

    public static void main(String[] args) {

        int n= 10000000;
        int numprimes = 0;
        int i;
        for (i = 1; i <= n; i++)
        {
            if (is_prime(i) == 1)
                numprimes ++;
        }

        System.out.println(numprimes);


        String[] names = {"Alex", "Nate", "Cool."};
        printArray(names);

    }

    public static void printArray(String... a ){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }

    private static int is_prime(int n)
    {
        /* handle special cases */
        if      (n == 0) return 0;
        else if (n == 1) return 0;
        else if (n == 2) return 1;

        int i;
        for(i=2;i<=(int)(Math.sqrt((double) n));i++)
            if (n%i==0) return 0;

        return 1;
    }
}
