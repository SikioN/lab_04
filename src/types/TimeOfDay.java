package types;

import utilities.CodeColor;

import java.util.Random;

public enum TimeOfDay {
    MORNING(CodeColor.YELLOW + "Утро" + CodeColor.NONCOLOR),
    AFTERNOON(CodeColor.BLUE + "День" + CodeColor.NONCOLOR),
    NIGHT(CodeColor.BLACK + "Ночь" + CodeColor.NONCOLOR);

    private final String title;
    private static final Random r;
    private static final TimeOfDay t;

    TimeOfDay(String title) {
        this.title = title;
    }

    static {
        r = new Random();
        t = values()[r.nextInt(TimeOfDay.values().length)];
    }

    public static TimeOfDay randomStyle() {
        return t;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
