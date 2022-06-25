import java.util.Scanner;

public class ProblemD {

    public static void main(String[] args) {

        int[][] matrix = {
               //1, 2, 3, 4, 5, 6, 7, 8, 9, 10
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 1}, // 1
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0}, // 2
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, // 3
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 0}, // 4
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, // 5
                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, // 6
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0}, // 7
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0}, // 8
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 1}, // 9
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0}};// 10

        Scanner scn = new Scanner(System.in);

        int num1 = scn.nextInt();
        int num2 = scn.nextInt();

        if (matrix[num1-1][num2-1] == 1) {

            System.out.println("Yes");

        } else {

            System.out.println("No");
        }

    }
}

/*
Scanner scn = new Scanner(System.in);

int num1 = scn.nextInt();
int num2 = scn.nextInt();

if (num1 - 1 == num2 || num2 - 1 == num1) {

    System.out.println("Yes");

} else {
    System.out.println("No");
}
* */