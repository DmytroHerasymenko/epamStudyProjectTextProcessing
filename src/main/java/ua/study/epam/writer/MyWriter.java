package ua.study.epam.writer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by dima on 28.02.17.
 */
public class MyWriter {

    public void writeToFile(String fileName, boolean append, String text){
        if(fileName == null || fileName.isEmpty()) throw new IllegalArgumentException();

        if (text == null || text.isEmpty())
            return;
        try {
            FileWriter writer = new FileWriter(fileName, append);
            writer.append(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
