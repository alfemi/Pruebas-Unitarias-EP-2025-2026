package Exceptions;

public class AlreadyDefinedException extends RuntimeException {
    public AlreadyDefinedException(String message) {
        super(message);
    }

}
