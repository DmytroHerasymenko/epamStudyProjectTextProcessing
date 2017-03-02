package ua.study.epam.main;

import ua.study.epam.text.Punctuation;
import ua.study.epam.text.Text;
import ua.study.epam.text.Word;
import ua.study.epam.textprocessing.TextProcessing;
import ua.study.epam.writer.MyWriter;

/**
 * Created by dima on 27.02.17.
 */
public class Main {
    public static void main(String[] args) {
        TextProcessing textProcessing = new TextProcessing();
        MyWriter writer = new MyWriter();

        Text text = new Text();
        text.receiveTextFromFile("src/read.txt");

        text = textProcessing.deleteWords(2, text);

        writer.writeToFile("src/wright.txt", false, text.toString());
    }
}
