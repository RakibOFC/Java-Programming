import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int[] alice = new int[3];
        int[] bob = new int[3];

        for(int i = 0; i < 3; i++) {

            alice[i] = scn.nextInt();
        }

        for(int i = 0; i < 3; i++) {

            bob[i] = scn.nextInt();
        }

        calculate(alice, bob);
    }

    private static void calculate(int[] alice, int[] bob) {

        int a = 0, b = 0;

        for(int i = 0; i < 3; i++) {

            if(alice[i] > bob[i]) {
                a++;
            }

            else if(alice[i] < bob[i]) {
                b++;
            }
        }
        System.out.println(a + " " + b);
    }
}