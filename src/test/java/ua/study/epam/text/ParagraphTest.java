package ua.study.epam.text;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dima on 02.03.17.
 */
public class ParagraphTest {

    @Test
    public void parseParagraphNullTest () throws Exception {
        Paragraph paragraph = new Paragraph(null);
        assertEquals("", paragraph.toString());
    }

    @Test
    public void parseParagraphTest () throws Exception {
        Paragraph paragraph = new Paragraph("String for check parse paragraph. Second sentence. Third sentence.");
        assertEquals(3, paragraph.getParagraph().size());
        assertEquals("Second sentence. ", paragraph.getParagraph().get(1).toString());
    }
}