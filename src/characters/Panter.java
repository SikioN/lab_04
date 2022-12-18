package characters;

import entities.Entity;
import myexception.UnsupportedMethod;
import places.Place;
import types.CodeColor;
import types.JumpTypes;


final public class Panter extends Character {
    public Panter(String name, Place location) {
        super(name, location);
    }

    @Override
    public void walk(Place newLocation) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }

    @Override
    public String getName() {
        return CodeColor.BLACK + super.getName() + CodeColor.NONCOLOR;
    }

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

    @Override
    public void watch(Entity entity) throws UnsupportedMethod {

    }

    @Override
    public void watch(Character character) throws UnsupportedMethod {

    }


}
