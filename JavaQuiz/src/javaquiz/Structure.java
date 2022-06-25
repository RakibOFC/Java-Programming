
package javaquiz;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Structure {
    
    public void writeScore(int score) throws FileNotFoundException, IOException, EOFException;
    public int readScore() throws FileNotFoundException, IOException, EOFException;
    public int initQuiz(int score) throws IOException;
}
