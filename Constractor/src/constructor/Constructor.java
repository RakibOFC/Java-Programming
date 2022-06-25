package constructor;

import java.util.Scanner;

class Suduko {
    
    Scanner input = new Scanner(System.in);
    int i, arr[] = new int[8];
    
    Suduko(){
        
        System.out.println("Enter eight digits: ");
        
        for(i = 0; i < 8; i++){
            arr[i] = input.nextInt();
        }
    }
    
    void display(){
        
        System.out.print("Numbers are: ");
        for(i = 0; i < 8; i++){
            
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

public class Constructor {

    public static void main(String[] args) {
        
        Suduko a = new Suduko();
        
        a.display();
    }

}
