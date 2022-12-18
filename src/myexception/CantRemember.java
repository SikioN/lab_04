package myexception;

public class CantRemember extends RuntimeException {
    public CantRemember(String message) {
        super(message);
    }
}
