package javaquiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Quiz extends Abstract implements Structure {

    int i, j;
    char ch;
    
    @Override
    public void writeScore(int score) throws FileNotFoundException, IOException, EOFException {
        try {
            FileWriter fw = new FileWriter("data.txt");
            try (BufferedWriter WriteFileBuffer = new BufferedWriter(fw)) {
                WriteFileBuffer.write(score);
            }
        } catch (IOException e) {
            
        }
    }

    @Override
    public int readScore() throws FileNotFoundException, IOException, EOFException {
        
        int score = 0;

        try {
            FileReader fr = new FileReader("data.txt");

            try (BufferedReader ReadFileBuffer = new BufferedReader(fr)) {
                score = ReadFileBuffer.read();
            }
            
        } catch (FileNotFoundException e) {
            //System.out.println(e.getMessage());
        }

        return score;
    }

    @Override
    public int initQuiz(int score) throws IOException {
        System.out.println("\n\t\t───────────────────");
        System.out.print("\t\t\tJava Quiz");
        System.out.print("\n\t\t───────────────────");
        System.out.println("\n\t\tEnter 'R' to restart quiz");
        System.out.println("\n\t\tEnter 'F' to finished quiz");
        System.out.println("\t\t───────────────────");
        
        // writeScore(score);

        Scanner scn = new Scanner(System.in);
        char option;
        
        for (i = 0; i < 10; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            for (j = 0, ch = 'a'; j < 4; j++, ch++) {
                System.out.println("\t" + ch + ". " + options[i][j]);
            }

            System.out.print("\nEnter your choice: ");
            option = scn.next().charAt(0);

            if (option == rightAnswers[i]) {
                score++;
                writeScore(score);
                score = readScore();
                System.out.print("Right answer! Score: " + score);
            } else if (option == 'R' || option == 'r') {
                System.out.println("Quiz Restarted!");
                score = 0;
                writeScore(score);
                initQuiz(score);
                return score;
            } else if (option == 'F' || option == 'f') {
                score = readScore();
                System.out.print("Quiz Finished!\n");
                return score;
            } else {
                score = readScore();
                System.out.print("Wrong answer!\nRight answer is (" + rightAnswers[i] + "), Score: " + score);
            }
            System.out.println("\n");
        }
        
        score = readScore();
        
        return score;
    }
}
