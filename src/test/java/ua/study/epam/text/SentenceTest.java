package ua.study.epam.text;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dima on 02.03.17.
 */
public class SentenceTest {

    @Test
    public void parseSentenceNullTest () throws Exception {
        Sentence sentence = new Sentence(null);
        assertEquals("", sentence.toString());
    }
    @Test
    public void parseSentencePunctuationTest () throws Exception {
        Sentence sentence = new Sentence("check, punctuation!");
        assertEquals(",", sentence.getSentence().get(1).toString());
        assertEquals("!", sentence.getSentence().get(3).toString());
    }

    @Test
    public void parseSentenceWordTest () throws Exception {
        Sentence sentence = new Sentence("check, punctuation!");
        assertEquals("check", sentence.getSentence().get(0).toString());
        assertEquals("punctuation", sentence.getSentence().get(2).toString());
    }
}