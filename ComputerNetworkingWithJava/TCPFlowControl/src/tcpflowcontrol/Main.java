package tcpflowcontrol;

import java.util.Random;
import java.util.Scanner;

public class Main {
    
    private static int generateFrame(int windowSize) {
        
        Random random = new Random();
        
        int i, noOfGenerateFrame;
        
        noOfGenerateFrame = random.nextInt(500) % windowSize;
        
        
        if(noOfGenerateFrame == 0){
             
            return windowSize;
        
        } else { 
            
            return noOfGenerateFrame;
        }
    }
    
    public static int generateAck(int noOfSent){
        
        Random random = new Random();
        
        int i, noOfAckFrame;
        
        return 0;
    }
    
    public static void main(String args[]){
        
        int noOfFrame, windowSize, startByte = 0, endByte = 0, noOfAck = 0, noOfSent = 0, duaFrame;
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the total number of frame: ");
        noOfFrame = in.nextInt();
        
        System.out.println("Enter the window size: ");
        windowSize = in.nextInt();
        
        duaFrame = noOfFrame;
        
        while(duaFrame >= 0){
            
            noOfSent = generateFrame(windowSize);
            
            endByte += noOfSent;
            
            if(endByte > noOfFrame){
                
                endByte = noOfFrame;
            }
            
            for(int i = startByte+1; i <= endByte; i++){
                
                System.out.println("Sending Frame: " + i);
            }
            
            noOfAck = generateAck(noOfSent);;
        }
    }
}
