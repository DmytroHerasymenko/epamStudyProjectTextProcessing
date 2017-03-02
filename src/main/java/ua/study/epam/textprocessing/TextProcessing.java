package ua.study.epam.textprocessing;

import ua.study.epam.text.*;

/**
 * Created by dima on 28.02.17.
 */
public class TextProcessing {

    public Text deleteWords(int wordLength, Text text) {
        if(wordLength < 1) throw new IllegalArgumentException();
        if(text == null || text.getText().isEmpty()) return null;

        Paragraph paragraph;
        Sentence sentence;
        Lexeme lexeme;
        String word;

        for(int i = 0; i < text.getText().size(); i++){
            paragraph = text.getText().get(i);
            for(int j = 0; j < paragraph.getParagraph().size(); j++){
                sentence = paragraph.getParagraph().get(j);
                for(int x = 0; x < sentence.getSentence().size(); x++){
                    lexeme = sentence.getSentence().get(x);

                    if(!checkWord(lexeme)) continue;

                    word = lexeme.toString().toLowerCase();
                    if(word.length() == wordLength && (isConsonantEn(word) || isConsonantRu(word))) {
                        sentence.getSentence().remove(x);
                        x--;
                    }
                }
            }
        }
        return text;
    }

    private boolean checkWord(Lexeme l) {
        switch (l.toString()) {
            case "(":
            case "\"":
            case ",":
            case ";":
            case ":":
            case ")":
            case ".":
            case "!":
            case "?":
            case "...":
                return false;
            default:
                return true;
        }
    }

    private boolean isConsonantEn(String word) {
        char[] chars = word.toCharArray();
        switch (chars[0]){
            case 'q':
            case 'w':
            case 'r':
            case 't':
            case 'p':
            case 's':
            case 'd':
            case 'f':
            case 'g':
            case 'h':
            case 'j':
            case 'k':
            case 'l':
            case 'z':
            case 'x':
            case 'c':
            case 'v':
            case 'b':
            case 'n':
            case 'm':
                return true;
            default: return false;
        }
    }

    private boolean isConsonantRu(String word) {
        char[] chars = word.toCharArray();
        switch (chars[0]){
            case 'й':
            case 'ц':
            case 'к':
            case 'н':
            case 'г':
            case 'ш':
            case 'щ':
            case 'з':
            case 'х':
            case 'ф':
            case 'в':
            case 'п':
            case 'р':
            case 'л':
            case 'д':
            case 'ж':
            case 'ч':
            case 'с':
            case 'м':
            case 'т':
            case 'б':
                return true;
            default: return false;
        }
    }
}

//(((Word) l).getWord().get(0).toString() == "н")

//String consonant = "[qwrtpsdfghjklzxcvbnmйцкнгшщзхфвпрлджчсмтб]";

/*for (Paragraph p : text.getText()) {

            for (Sentence s : p.getParagraph()) {

                for (Lexeme l : s.getSentence()) {

                    //if(l instanceof Punctuation) continue;
                    if(!checkLexeme(l)){
                        //resText.getText().get(countParagraph).getParagraph().get(countSentence).getSentence().add(l);
                        continue;
                    }

                    if (l.toString().length() == wordLength) {
                        resText.getText().get(countParagraph).getParagraph().get(countSentence).getSentence().remove(l);

                        //continue;
                    }
                    //resText.getText().get(countParagraph).getParagraph();
                    //.get(countSentence).getSentence().add(l);
                }
                countSentence++;
            }
            countParagraph++;
        }*/
