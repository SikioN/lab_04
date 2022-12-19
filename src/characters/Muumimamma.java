package characters;

import entities.Entity;
import myexception.CantRemember;
import places.DreamWorld;
import places.Place;
import types.EmotionType;
import utilities.CodeColor;
import utilities.Color;


final public class Muumimamma extends Moomins {
    public Muumimamma(String name, Place location) {
        super(name, location);
    }

    @Override
    public String getName() {
        return CodeColor.PINK + super.getName() + CodeColor.NONCOLOR;
    }


    @Override
    public String getRemember(String about) {
        if (about == null) {
            about = "небытие";
        }
        return String.format("Думает %s о %s.\n", EmotionType.randomStyle(), about);
    }

    @Override
    public void remember() throws CantRemember {
        if (Math.random() >= 0.6) {

            DreamWorld beach = new DreamWorld.Builder2("Пляж").build();
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

            throw new CantRemember(this.getName() + CodeColor.RED + " ничего " + CodeColor.NONCOLOR + "не пришло на ум...");

        }
    }
}
