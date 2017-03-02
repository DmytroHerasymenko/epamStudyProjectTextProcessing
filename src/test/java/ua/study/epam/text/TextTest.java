package ua.study.epam.text;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dima on 02.03.17.
 */
public class TextTest {
    Text text = new Text();

    @Test(expected = IllegalArgumentException.class)
    public void receiveTextFromFileNullTest() throws Exception {
        text.receiveTextFromFile(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void receiveTextFromFileEmptyTest() throws Exception {
        text.receiveTextFromFile("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void receiveTextFromFileNoSuchFileTest() throws Exception {
        text.receiveTextFromFile("cfg.txt");
    }
    @Test
    public void receiveTextFromFileTest() throws Exception {
        text.receiveTextFromFile("src/testDelete.txt");
        assertEquals(text.getText().get(0).toString(), "Check re if text GF processing, fd, delete words! ");
    }
}