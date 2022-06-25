import java.util.ArrayList;
import java.util.Scanner;

public class ProblemH {

    static int findDigits(int n)
    {
        if (n < 0) {
            return 0;
        }

        if (n <= 1) {
            return 1;
        }

        double digits = 0;

        for (int i=2; i<=n; i++)
            digits += Math.log10(i);

        return (int)(Math.floor(digits)) + 1;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int m = scn.nextInt();

        int[] numbers = new int[m];

        for (int i = 0; i < m; i++) {

            numbers[i] = scn.nextInt();
        }

        for (int i = 0; i < m; i++) {

            System.out.println(findDigits(numbers[i]));
        }
    }
}
