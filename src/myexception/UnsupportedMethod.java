package myexception;

public class UnsupportedMethod extends RuntimeException{
    public UnsupportedMethod() {
        super("Сейчас этот метод не используется для этого класса!");
    }
}
