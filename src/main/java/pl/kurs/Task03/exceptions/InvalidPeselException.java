package pl.kurs.Task03.exceptions;

public class InvalidPeselException extends RuntimeException {
    public InvalidPeselException(String message) {
        super(message);
    }
}
