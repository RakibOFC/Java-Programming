package javaquiz;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        int score = 0;

        while (true) {
            System.out.println("\t\tWelcome To Quiz Management System");
            System.out.println("\n\t\t───────────────────");
            System.out.println("\n\t\tEnter 'S' to Start Quiz");
            System.out.println("\n\t\tEnter 'V' to View Score");
            System.out.println("\n\t\tEnter 'Q' to Quit");
            System.out.println("\n\t\t───────────────────\n\n\t\t");

            Scanner scn = new Scanner(System.in);
            Quiz session = new Quiz();

            char option;

            menu:
            while (true) {
                System.out.print("Enter your choice: ");
                option = scn.next().charAt(0);

                switch (option) {
                    case 'S':
                    case 's':
                        score = session.initQuiz(0);
                        break menu;

                    case 'V':
                    case 'v':   
                        score = session.readScore();
                        System.out.println("Your score is = " + score);
                        break menu;

                    case 'Q':
                    case 'q':
                        System.out.println("You've exited successfully!");
                        System.exit(0);
                }
            }
            
            System.out.print("\n'M' for Main Menu\n'Q' for Quit\n\nEnter your choice: ");
            option = scn.next().charAt(0);

            switch (option) {
                case 'M':
                case 'm':
                    break;

                case 'Q':
                case 'q':
                    System.out.println("You've exited successfully!");
                    System.exit(0);
            }
            
            System.out.println("\n");
        }
    }
}
