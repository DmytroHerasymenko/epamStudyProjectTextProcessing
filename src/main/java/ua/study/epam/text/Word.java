package ua.study.epam.text;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dima on 27.02.17.
 */
public class Word implements Lexeme {
    // for do changes in the middle of list. We need queue and don't need select random element
    private final List<Sign> word = new LinkedList<>();

    public Word(String word){
        if(word == null) return;
        char[] characters = word.toCharArray();
        for(char ch : characters){
            this.word.add(new Sign(ch));
        }
    }

    public List<Sign> getWord() {
        return word;
    }

    @Override
    public String toString() {
        return this.getWordString();
    }

    private String getWordString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Sign s : word){
            stringBuilder.append(s.getSign());
        }
        return stringBuilder.toString();
    }
}
