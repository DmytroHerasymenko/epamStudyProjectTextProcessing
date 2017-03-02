package ua.study.epam.text;

/**
 * Created by dima on 28.02.17.
 */
public class Punctuation implements Lexeme {

    private final String punctuation;

    public Punctuation(String punctuation){
        this.punctuation = punctuation;
    }

    public String getPunctuation() {
        return punctuation;
    }

    @Override
    public String toString() {
        return "" + punctuation;
    }
}

/*public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String SEMICOLON = ";";
    public static final String QUOTEMARKS = "\"";
    public static final String BRACKETSTART = "(";
    public static final String BRACKETEND = ")";*/