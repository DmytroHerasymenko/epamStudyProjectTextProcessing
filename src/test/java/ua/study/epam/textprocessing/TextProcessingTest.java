package ua.study.epam.textprocessing;

import org.junit.Test;
import ua.study.epam.text.Text;

import static org.junit.Assert.*;

/**
 * Created by dima on 02.03.17.
 */
public class TextProcessingTest {
    TextProcessing textProcessing = new TextProcessing();
    Text text = new Text();

    @Test(expected = IllegalArgumentException.class)
    public void deleteWordsIllegalLengthTest() throws Exception {
        textProcessing.deleteWords(0, text);
    }
    @Test
    public void deleteWordsNullTextTest() throws Exception {
        text = null;
        assertNull(textProcessing.deleteWords(4, text));
    }
    @Test
    public void deleteWordsEmptyTextTest() throws Exception {
        assertNull(textProcessing.deleteWords(4, text));
    }
    @Test
    public void deleteWordsTest() throws Exception {
        text.receiveTextFromFile("src/testDelete.txt");
        text = textProcessing.deleteWords(2, text);
        assertEquals(text.getText().get(0).toString(), "Check if text processing,, delete words! ");
    }

}