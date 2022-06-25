public class Diamonds {
    
    public static void main(String args[]){
        
        int i, j, k = 1, l, size = 5;
        
        int horizontalBorder = size * 2 + 2;
        int verticalBorder = size * 2 + 1;
        int mid = verticalBorder / 2 + 1;
        
        for(i = 1; i <= verticalBorder; i++){
            
            k = 1;
            l = 1;
            for(j = 1; j <= horizontalBorder; j++){
                
                if(i == 1 && j == 1 || i == 1 && j == horizontalBorder || i == verticalBorder && j == 1 || i == verticalBorder && j == horizontalBorder){
                    
                    System.out.print("+");
                
                } else if (i == 1 || i == verticalBorder){
                    
                    System.out.print("-");
                
                } else if(j == 1 || j == horizontalBorder){
                    
                    System.out.print("|");
                
                } else if(i % 2 == 0){
                    
                    if(k++ < size && l++ < i){
                        
                        System.out.print(" ");
                        
                    } else{
                        
                        System.out.print("=");
                    }
                
                } else if(i % 2 != 0){
                    
                    System.out.print("-");
                
                } else if(i == mid && j == 2){
                    
                    System.out.print("<");
                
                } else if(i == mid && j == horizontalBorder - 1){
                    
                    System.out.print(">");
                
                } else if(i == mid){
                    
                    System.out.print("=");
                }
            }
            System.out.println();
        }
    }
}
