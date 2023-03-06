package africa.semicolon.eventbrite.exception;

public class DuplicatedEmailException extends RuntimeException {

    public DuplicatedEmailException(String s) {
        super(s);
    }
}
