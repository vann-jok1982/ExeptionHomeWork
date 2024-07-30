package isklyucheniya;

public class NotLettersException extends RuntimeException{

    public NotLettersException(String s) {
        super(s+" - содержит недопустимые символы.");
    }
}
