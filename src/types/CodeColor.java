package types;

public enum CodeColor {
    VIOLET ("\u001B[35m"),
    BLUE ("\u001B[34m"),
    YELLOW ("\u001B[33m"),
    GREEN ("\u001B[32m"),
    BLACK ("\u001B[30m"),
    CYAN ("\u001B[36m"),
    WHITE ("\u001B[37m"),
    RED ("\u001B[31m"),
    NONCOLOR("\u001B[0m");

    private final String title;

    CodeColor(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title;
    }

}
