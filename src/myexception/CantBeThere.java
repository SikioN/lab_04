package myexception;

public class CantBeThere extends RuntimeException {
    public CantBeThere(String message) {
        super(message);
    }
}