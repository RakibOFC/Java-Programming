package presearch;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;

public class Presearch {

    private static void adressBar() throws AWTException, InterruptedException {

        Thread.sleep(1000);
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_L);
        Thread.sleep(500);

        /*pre*/
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public static void main(String[] args) throws IOException,
            AWTException, InterruptedException {
        int search_input, i = 0;

        Robot robot = new Robot();
        
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_TAB);
        
        for (search_input = 65; search_input <= 90; search_input++) {

            adressBar();

            Thread.sleep(1500);

            robot.keyPress(search_input);
            robot.keyRelease(search_input);
            Thread.sleep(1000);

            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(1000);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(10000);
            
            if(search_input == 90){
                
                search_input = 65;
            }
            if(i++ > 40){
                break;
            }
        }
    }
}
