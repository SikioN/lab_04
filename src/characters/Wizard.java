package characters;

import entities.Rubin;
import myexception.FellOutOfTheWorld;
import places.Place;
import types.EmotionType;
import utilities.CodeColor;
import utilities.Color;

import java.util.ArrayList;
import java.util.Date;

final public class Wizard extends Character implements Relaxing {

    public Wizard(String name, Place location) {
        super(name, location);
    }

    @Override
    public String getName() {
        return CodeColor.VIOLET + super.getName() + CodeColor.NONCOLOR;
    }

    @Override
    public void walk(Place newLocation) {
        String message;

        if (newLocation == null) {
            throw new FellOutOfTheWorld(this.getName());
        } else {
            message = String.format("И " + this.getName() + " взял путь прямо из %s в %s! ", this.getLocation(), newLocation.getName());
            this.setLocation(newLocation);
        }

        System.out.print(message);
    }

    @Override
    public void watch(Character character) {
        if (character != null) {
            this.voiceLine(String.format("Там стоит %s", character.getName()));
        } else {
            this.voiceLine("Там никого нет");
        }
    }

    @Override
    public void relax() {
        String et = String.valueOf(EmotionType.randomStyle());
        System.out.printf("%s %s отдыхал в %s", et.substring(0, 1).toUpperCase() + et.substring(1), this.getName(), this.getLocation());
    }

    public void realized(Rubin entity) {
        if (entity == null) {
            voiceLine("Там нет рубина...");
        } else {
            voiceLine(String.format("%s находится у %s", entity.getName(), entity.getOwner()));
        }
    }

    public void gotDressed() {
        String[] clothes = {"Перчатки", "Плащ", "Цилиндр", "Очки"};
        System.out.print(this);
        for (String c :
                clothes) {
            if (Math.random() >= 0.5) {
                System.out.printf(" %s %sвзял%s,", c, CodeColor.GREEN, CodeColor.NONCOLOR);
            } else {
                System.out.printf(" %s %sзабыл%s,", c, CodeColor.RED, CodeColor.NONCOLOR);
            }
        }
    }

    public void shakeOut() {
        System.out.print(" \nа также " + this.getName() + CodeColor.GREEN + " взял " + CodeColor.NONCOLOR + "свой рюкзак и");
        ArrayList<Rubin> bag = new ArrayList<>();
        Color color;

        final class ExtraRubin extends Rubin {
            public ExtraRubin(Place place, Character owner, Color color) {
                super(place, owner, color);
            }

            @Override
            public String toString() {
                return this.getName();
            }
        }

        for (int i = 0; i < Color.values().length / 3; i++) {
            color = Color.randomStyle();

            if (color == Color.ORANGEREDCRAYOLA) {
                color = Color.RED;
            }

            ExtraRubin extraRubin = new ExtraRubin(this.getLocation(), this, color);
            bag.add(extraRubin);
        }

        for (Rubin rubin : bag) {
            if (Math.random() >= 0.2) {
                System.out.printf(" выкинул %s,", rubin);
            } else {
                System.out.printf(" оставил %s,", rubin);
            }
        }
        Date date = new Date();
        System.out.printf("\nпотому что его интересовал только один Рубин, который, как он надеялся, он сможет забрать уже через %s минут!", date.getMinutes());
    }

    public void saddled(Panter panter) {
        if (panter == null || !(panter.equals(this))) {
            System.out.print("\nНе смог оседлать никого.\n");
        } else {
            System.out.printf("\n%s залез на спину %s. ", this.getName(), panter.getName());
        }
    }

}
