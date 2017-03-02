package ua.study.epam.text;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dima on 27.02.17.
 */
public class Sentence {
    // for do changes in the middle of list. We need queue and don't need select random element
    private final List<Lexeme> sentence = new LinkedList<>();

    public Sentence(String sentence){
        if(sentence == null) return;
        List<String> stringList = Arrays.asList(sentence.split(" "));
        for(String s : stringList){
            createLexemes(s);
        }
    }

    public List<Lexeme> getSentence() {
        return sentence;
    }

    @Override
    public String toString() {
        return this.getSentenceString();
    }

    private String getSentenceString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Lexeme l : sentence){
            checkLexemes(l, stringBuilder);
        }
        return stringBuilder.toString();
    }

    private void createLexemes(String s){
        if(s.startsWith("(") || s.startsWith("\"")) {
            this.sentence.add(new Punctuation(s.substring(0,1)));
            s = s.substring(1);
        }
        if(s.endsWith(",") || s.endsWith(";") || s.endsWith(":") || s.endsWith(")") || s.endsWith("\"")
                || s.endsWith(".") || s.endsWith("...") || s.endsWith("!") || s.endsWith("?") ) {
            String temp = s.substring(s.length()-1);
            this.sentence.add(new Word(s.substring(0, s.length()-1)));
            this.sentence.add(new Punctuation(temp));
        } else {
            this.sentence.add(new Word(s));
        }
    }

    private void checkLexemes(Lexeme l, StringBuilder stringBuilder) {
        int length;
        switch (l.toString()){
            case "" : break;
            case "(" :
            case "\"" :
                stringBuilder.append(l);
                break;
            case "," :
            case ";" :
            case ":" :
            case ")" :
            case "." :
            case "!" :
            case "?" :
            case "..." :
                length = stringBuilder.length()-1;
                stringBuilder.replace(length, length, l.toString());
                break;
            default:
                stringBuilder.append(l);
                stringBuilder.append(" ");
        }
    }
}

// ^ начало строки
// $ конец строки
// s.split("^[(\"]");

/*if(s.startsWith("(") || s.startsWith("\"")) {
                this.sentence.add(new Punctuation(s.substring(0,1)));
                s = s.substring(1);
            }
            if(s.endsWith(",") || s.endsWith(";") || s.endsWith(":") || s.endsWith(")") || s.endsWith("\"")
                    || s.endsWith(".") || s.endsWith("...") || s.endsWith("!") || s.endsWith("?") ){
                String temp = s.substring(s.length()-1);
                s = s.substring(0, s.length()-1);
                this.sentence.add(new Word(s));
                this.sentence.add(new Punctuation(temp));
            } else {
                this.sentence.add(new Word(s));
            }*/

/*private void createLexemes(String s){
        switch (s){
            case "(":
            case "\"":
            case "," :
            case ";" :
            case ":" :
            case ")" :
            case "." :
            case "!" :
            case "?" :
            case "..." :
                this.sentence.add(new Punctuation(s));
                break;
            default: this.sentence.add(new Word(s));
        }
    }*/

/*if(l instanceof Punctuation) {
                length = stringBuilder.length()-1;
                stringBuilder.replace(length, length, l.toString());
            } else {
                stringBuilder.append(l);
                stringBuilder.append(" ");
            }*/