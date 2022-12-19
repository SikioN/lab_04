package phrase;

import java.util.Random;

public enum VoiceLinesRubyKing {
    SILENTLY ("Хммм..."),
    RUBIN ("Нужно больше Рубинов!"),
    ENTHUSIASTICALLY ("Я – король! Король РУБИНОВ!"),
    ARROGANTLY ("Королями не становятся... Ими рождаются! Ха-ха-ха!");

    private final String title;
    private static final Random r;

    VoiceLinesRubyKing(String title) {
        this.title = title;
    }

    static {
        r = new Random();
    }

    public static VoiceLinesRubyKing randomStyle() {
        return values()[r.nextInt(VoiceLinesRubyKing.values().length)];
    }

    @Override
    public String toString() {
        return this.title;
    }
}
