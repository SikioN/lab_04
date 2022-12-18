package characters;

import places.Place;
import utilities.CodeColor;
import types.JumpTypes;


final public class Panter extends Character {
    public Panter(String name, Place location) {
        super(name, location);
    }


    @Override
    public String getName() {
        return CodeColor.BLACK + super.getName() + CodeColor.NONCOLOR;
    }

    @Override
    public void jump(Place newLocation) {
        String message;
        if (newLocation == null) {
            message = String.format(this.getName() + " не захотела прыгать и осталась в %s.\n", this.getLocation());
        } else {
            message = String.format(this.getName() + " %s спрыгнула с %s и приземлилась в %s.\n", JumpTypes.randomStyle(), this.getLocation(), newLocation.getName());
            this.setLocation(newLocation);
        }
        System.out.print(message);
    }

}
