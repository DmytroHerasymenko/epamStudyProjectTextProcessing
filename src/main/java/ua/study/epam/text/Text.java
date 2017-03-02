package ua.study.epam.text;

/**
 * Created by dima on 27.02.17.
 */

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Text {
    // for do changes in the middle of list. We need queue and don't need select random element
    private final List<Paragraph> text = new LinkedList<>();

    public void receiveTextFromFile(String fileName){
        if(fileName == null || fileName.isEmpty()) throw new IllegalArgumentException();

        File file = new File(fileName);
        if(!file.exists()) throw new IllegalArgumentException();

        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while(bufferedReader.ready()){
                String paragraph = bufferedReader.readLine();
                paragraph = paragraph.replaceAll("\\s+", " ");
                text.add(new Paragraph(paragraph));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Paragraph> getText() {
        return text;
    }

    @Override
    public String toString() {
        return getTextString();
    }

    private String getTextString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Paragraph p : text){
            stringBuilder.append(p);
            stringBuilder.append("\r");
        }
        return stringBuilder.toString();
    }
}

/*public void receiveTextFromFile(String fileName){
        File file = new File(fileName);
        BufferedReader bufferedReader;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while(bufferedReader.ready()){
                String paragraph = bufferedReader.readLine();
                paragraph = paragraph.replaceAll("\\s+", " ");
                stringBuilder.append(paragraph);
                stringBuilder.append("\r");
            }
            bufferedReader.close();
            text = stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/