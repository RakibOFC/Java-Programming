
import java.util.Scanner;

public class ProblemE {
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        int m, n;
        
        m = scn.nextInt();
        n = scn.nextInt();
        
        String line;
        
        char[][] chessman = new char[n][m];
        
        for(int i = 0; i < n; i++) {
            
            line = scn.next();
            
            for(int j = 0; j < m; j++) {
                
                chessman[j][i] = line.charAt(j);
            }
            
        }
        
        for(int i = 0; i < m; i++) {
            
            for(int j = 0; j < n; j++) {

                if(chessman[j][i] == '.') {

                    if((j+i) % 2 == 0) {

                        chessman[j][i] = 'B';
                    }
                    else {
                        chessman[j][i] = 'W';
                    }
                }
            }
        }

        for(int i = 0; i < n; ++i)
        {
            for(int j=0; j < m; ++j){

                System.out.print(chessman[j][i]);
            }
            System.out.println();
        }
    }
}
