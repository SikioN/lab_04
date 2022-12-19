package types;

import java.util.Random;

public enum EmotionType {
    SILENTLY("безмолвно"),
    ALARMINGLY("тревожно"),
    CHEERFULLY("радостно"),
    TIREDLY("уставше");

    private final String title;
    private static final Random r;

    EmotionType(String title) {
        this.title = title;
    }

    static {
        r = new Random();
    }

    public static EmotionType randomStyle() {
        return values()[r.nextInt(EmotionType.values().length)];
    }

    @Override
    public String toString() {
        return this.title;
    }
}
