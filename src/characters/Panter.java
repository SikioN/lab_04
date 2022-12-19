package characters;

import places.Place;
import types.JumpTypes;
import utilities.CodeColor;


final public class Panter extends Character implements Relaxing {
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
            message = String.format(this.getName() + " %s приземлилась в %s.\n", JumpTypes.randomStyle(), newLocation.getName());
            this.setLocation(newLocation);
        }
        System.out.print(message);
    }

    @Override
    public void relax() {
        System.out.printf(", а %s спала.\n", this.getName());
    }
}
