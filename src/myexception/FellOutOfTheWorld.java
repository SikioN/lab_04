package myexception;

public class FellOutOfTheWorld extends RuntimeException {
    public FellOutOfTheWorld(String name) {
        super(String.format("%s выпал из мира", name));
    }
}
