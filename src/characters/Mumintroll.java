package characters;

import myexception.CantRemember;
import places.DreamWorld;
import places.Place;
import utilities.CodeColor;
import types.ThinkingType;


final public class Mumintroll extends Moomins {
    public Mumintroll(String name, Place location) {
        super(name, location);
    }

    @Override
    public String getName() {
        return CodeColor.BLUE + super.getName() + CodeColor.NONCOLOR;
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
        if (Math.random() >= 0.4) {
            DreamWorld worldOfMemories = new DreamWorld.Builder2("Мир воспоминаний").build();
            System.out.print(this.getName() + CodeColor.GREEN + " отправился " + CodeColor.NONCOLOR + "в Мир воспоминаний, ");
            Place oldLocation = this.getLocation();

            this.setLocation(worldOfMemories);

            Character snusmumriken = new Character("Снусмумрик", worldOfMemories) {
                @Override
                public String getName() {
                    return super.getName();
                }
            };

            if (this.equals(snusmumriken)) {
                System.out.printf("где встретился с %s! ", snusmumriken.getName());
            }

            System.out.printf("После чего вернулся в %s.\n", oldLocation.getName());
            this.setLocation(oldLocation);

        } else {

            throw new CantRemember(this.getName() + CodeColor.RED + " ничего " + CodeColor.NONCOLOR + "не вспомнил!");

        }
    }
}
