
public class Two {

    public static <T extends Comparable <T>> void workWithElement(T arr[]){
        
        for(int i = 0; i < arr.length -1; i++){
            
            for(int j = 0; j < arr.length -i - 1; j++){
                
                if(arr[j].compareTo(arr[j+1]) > 0){
                    
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        
        for(int i = 0; i < arr.length; i++){
            
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String args[]) {

        Integer arr[] = {3, 1, 5, 4, 2};
        workWithElement(arr);
        
        System.out.println("");
        
        String names[] = {"Rakib", "Ajmira", "Sathi", "Yamin"};
        workWithElement(names);
    }
}
