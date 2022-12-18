package characters;

import entities.Entity;
import myexception.UnsupportedMethod;
import places.DreamWorld;
import places.Place;
import types.CodeColor;
import types.Color;
import types.ThinkingType;


final public class Muumimamma extends Character implements Remember {
    public Muumimamma(String name, Place location) {
        super(name, location);
    }

    @Override
    public String getName() {
        return CodeColor.CYAN + super.getName() + CodeColor.NONCOLOR;
    }

    @Override
    public void jump(Place newLocation) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }


    @Override
    public void walk(Place newLocation) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }

    @Override
    public void watch(Character character) {
        if (this.equals(character)) {
            this.voiceLine(String.format("Вот %s", character.getName()));
        } else {
            this.voiceLine("Ой... здесь ничего нет.");
        }
    }

    @Override
    public void watch(Entity entity) {
        if (this.getLocation().getClass().equals(entity.getLocation().getClass()) && this.getLocation().getName().equals(entity.getLocation().getName())) {
            this.voiceLine(String.format("Вот %s", entity.getName()));
        } else {
            this.voiceLine("Ой... здесь ничего нет.");
        }
    }

    @Override
    public String getRemember(String about) {
        if (about == null) {
            about = "небытие";
        }
        return String.format("Думает %s о %s.\n", ThinkingType.randomStyle(), about);
    }

    @Override
    public void remember() {
        if (Math.random() >= 0.3) {

            DreamWorld beach = new DreamWorld("Пляж");
            System.out.print(this.getName() + " казалось, что" + CodeColor.GREEN + " отправилась " + CodeColor.NONCOLOR + "на Пляж, ");
            Place oldLocation = this.getLocation();


            this.setLocation(beach);

            class Carnation extends Entity {
                private final Color specificity;
                private final String code;

                public Carnation() {
                    super("Гвоздика", beach);
                    specificity = Color.randomStyle();
                    code = CodeColor.values()[specificity.ordinal()].getTitle();
                }

                public void swinging() {
                    int rate = -1 + (int) (Math.random() * 3);
                    String message = code + this.getSpecificity() + CodeColor.NONCOLOR + " " + this.getName() + (rate > 0 ? " медленно качалась. " : " была застывшей... ");
                    System.out.print(message);
                }

                public String getSpecificity() {
                    return specificity.getTitle();
                }

            }
            Carnation cr = new Carnation();

            if (this.getLocation().getName().equals(cr.getLocation().getName())) {
                this.watch(cr);
                cr.swinging();
            }

            System.out.printf("После чего вернулась в %s.\n", oldLocation.getName());
            this.setLocation(oldLocation);

        } else {
            System.out.print(this.getName() + "\u001B[31m" + " ничего " + "\u001B[0m" + "не пришло на ум...");
        }

    }


}
