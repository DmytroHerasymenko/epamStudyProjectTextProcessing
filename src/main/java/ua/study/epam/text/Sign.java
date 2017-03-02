package ua.study.epam.text;

/**
 * Created by dima on 27.02.17.
 */
public class Sign {
    private final char sign;

    public Sign(char sign){
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return Character.toString(sign);
    }
}
