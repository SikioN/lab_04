package characters;

import myexception.CantRemember;
import places.DreamWorld;
import places.Place;
import utilities.CodeColor;
import types.ThinkingType;


final public class FrekenSnorken extends Moomins {
    public FrekenSnorken(String name, Place location) {
        super(name, location);
    }

    @Override
    public String getName() {
        return CodeColor.GREEN + super.getName() + CodeColor.NONCOLOR;
    }

    @Override
    public String getRemember(String about) {
        if (about == null) {
            about = "небытие";
        }
        return String.format("Размышляет %s о %s.\n", ThinkingType.randomStyle(), about);
    }

    @Override
    public void remember() {
        if (Math.random() >= 0.5) {
            DreamWorld woodenKingdom = new DreamWorld.Builder2("Деревянное королевство").build();
            System.out.print(this.getName() + CodeColor.GREEN + " думала " + CodeColor.NONCOLOR + "о Деревянном королевстве, ");
            Place oldLocation = this.getLocation();

            this.setLocation(woodenKingdom);

            Character woodenQueen = new Character("Деревянная королев", woodenKingdom) {
                @Override
                public String getName() {
                    return super.getName();
                }
            };

            if (this.equals(woodenQueen)) {
                System.out.printf("где вновь встретилась в битве с %s! ", woodenQueen.getName());
            }

            if (Math.random() >= 0.8) {
                System.out.print("Как прежде, " + CodeColor.GREEN + "победив" + CodeColor.NONCOLOR + " вернулась в " + oldLocation.getName() + "!\n");
            } else {
                System.out.print("Но в этот раз " + CodeColor.RED + "проиграла" + CodeColor.NONCOLOR + " и вернулась в " + oldLocation.getName() + "...\n");
            }

            this.setLocation(oldLocation);

        } else {

            throw new CantRemember(this.getName() + CodeColor.RED + " ничего " + CodeColor.NONCOLOR + "не вспомнила!\n");

        }

    }
}
