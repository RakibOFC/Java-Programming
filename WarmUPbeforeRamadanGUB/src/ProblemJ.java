import java.util.ArrayList;
import java.util.Scanner;

public class ProblemJ {
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        ArrayList<Integer> number = new ArrayList<>();
        
        int N, uniqueCount = 0;
        boolean isDup;
        
        N = scn.nextInt();
               
        int[] numbers = new int[N];
        
        for(int i = 0; i < N; i++) {
        
            numbers[i] = scn.nextInt();
        }
        
        for(int i = 0; i < N; i++) {
            
            number.add(numbers[i]);
            isDup = false;
            
            for(int j = 0; j < number.size(); j++) {
                
                if(number.get(i).equals(numbers[j]) && i != j) {
                    
                    isDup = true;
                }
            }
            
            if(!isDup) {
                
                uniqueCount++;
            }
        }
        
        System.out.println(uniqueCount);
    }
}
