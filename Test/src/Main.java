
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static boolean isDuplicate(ArrayList<Integer> numbers, int randomNumber){
        
        for (int i = 0; i < numbers.size(); i++) {
            
            if (numbers.get(i) == randomNumber) {
                
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String args[]) {

        Random random = new Random();

        int uniqueNumberCount = 0, randomNumber, limit;
        
        ArrayList<Integer> pastNumber = new ArrayList<>();
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a limit of random number: ");
        limit = in.nextInt();
        
        for (int i = 0; uniqueNumberCount < limit; i++) {
            
            randomNumber = random.nextInt(limit) + 1;
            
            if (!isDuplicate(pastNumber, randomNumber)) {
                
                System.out.println(randomNumber);
                
                pastNumber.add(uniqueNumberCount++, randomNumber);
            }
        }

    }
}
