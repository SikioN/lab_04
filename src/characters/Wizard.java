package characters;

import myexception.FellOutOfTheWorld;
import places.Place;
import utilities.CodeColor;

final public class Wizard extends Character {

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
            message = String.format("А " + this.getName() + " взял путь прямо из %s в %s! ", this.getLocation(), newLocation.getName());
            this.setLocation(newLocation);
        }

        System.out.print(message);
    }


}
