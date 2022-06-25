import java.util.Random;

public class Two {

    public static void main(String args[]) {

        int numbers[] = {3, 1, 8, 4, 9};
        int cloneNumbers[] = new int[10];
        int size = 5, length = cloneNumbers.length;
        
        for(int i = 0; i < size; i++){
            
            cloneNumbers[i] = numbers[i];
            cloneNumbers[length-i-1] = numbers[i];
        }
        
        for(int i = 0; i < length; i++){
            
            System.out.print(cloneNumbers[i] + " ");
        }
    }
}
