package neobuxadprize;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;

public class NeobuxAdPrize {

    public static void main(String[] args) throws IOException,
            AWTException, InterruptedException {
        int search_input, i = 0;

        /*
        Before RUN it, please copy this code

        var button = document.getElementById("nxt_bt_a");
        setInterval(function(){
        button.click()
        }, 10000)
        */
        
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_TAB);

        for (search_input = 1; search_input <= 50; search_input++) {
            
            Thread.sleep(1500);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            
            Thread.sleep(10000);
        }
    }
}
