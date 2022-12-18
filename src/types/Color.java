package types;

import java.util.Random;

public enum Color {
//    VIOLET ("Фиолетовый"), /*CsCl*/
//    BLUE ("Синий"), /*CH3OH*/
//    YELLOW ("Жёлтый"), /*NaCl*/
//    GREEN ("Зелёный"), /*CaCl2*/
//    RED ("Красный");  /*LiCl*/
    VIOLET ("Фиолетовый"),
    BLUE ("Синий"),
    YELLOW ("Жёлтый"),
    GREEN ("Зелёный"),
    BLACK ("Чёрный"),
    CYAN ("Сине-зелёный"),
    WHITE ("Белый"),
    RED ("Красный"),
    NONCOLOR("Невидимый");

    private final String title;
    private static final Random r;

    Color(String title) {
        this.title = title;
    }

    static {
        r = new Random();
    }

    public String getTitle() {
        return title;
    }

    public static Color randomStyle() {
        return values()[r.nextInt(Color.values().length)];
    }

    @Override
    public String toString() {
        return this.title;
    }
}
