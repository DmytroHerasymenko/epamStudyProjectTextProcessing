package ua.study.epam.writer;

import org.junit.Test;
import ua.study.epam.text.Text;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by dima on 02.03.17.
 */
public class MyWriterTest {
    MyWriter myWriter = new MyWriter();
    Text text = new Text();

    @Test(expected = IllegalArgumentException.class)
    public void writeToFileNullFileName() throws Exception {
        myWriter.writeToFile(null, false, "asdad adsadse");
    }
   @Test(expected = IllegalArgumentException.class)
    public void writeToFileEmptyFileName() throws Exception {
       myWriter.writeToFile("", false, "asdad adsadse");
    }
    @Test
    public void writeToFileNullText() throws Exception {
        myWriter.writeToFile("src/testWriteNull.txt", false, null);
        text.receiveTextFromFile("src/testWriteNull.txt");
        assertEquals(true, text.toString().isEmpty());
    }
    @Test
    public void writeToFileEmptyTest() throws Exception {
        myWriter.writeToFile("src/testWriteNull.txt", false, "");
        text.receiveTextFromFile("src/testWriteNull.txt");
        assertEquals(true, text.toString().isEmpty());

    }
    @Test
    public void writeToFileTest() throws Exception {
        myWriter.writeToFile("src/testWrite.txt", false, "qwertyuiop asdfghjkl;'");
        text.receiveTextFromFile("src/testWrite.txt");
        assertEquals("qwertyuiop asdfghjkl;' ", text.getText().get(0).toString());
    }
}