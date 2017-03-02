package ua.study.epam.text;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dima on 27.02.17.
 */
public class Paragraph {
    // for do changes in the middle of list. We need queue and don't need select random element
    private final List<Sentence> paragraph = new LinkedList<>();

    public Paragraph(String paragraph){
        if(paragraph == null) return;
        List<String> stringList = Arrays.asList(paragraph.split("(?<=[!?.])\\s"));
        for(String s : stringList){
            this.paragraph.add((new Sentence(s)));
        }
    }

    public List<Sentence> getParagraph() {
        return paragraph;
    }

    @Override
    public String toString() {
        return this.getParagraphString();
    }

    private String getParagraphString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Sentence s : paragraph){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}