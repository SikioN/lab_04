package characters;

import entities.Entity;
import myexception.UnsupportedMethod;
import places.Place;
import types.CodeColor;

final public class Wizard extends Character {

    public Wizard(String name, Place location) {
        super(name, location);
    }

    @Override
    public void jump(Place newLocation) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }

    @Override
    public void watch(Entity entity) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }

    @Override
    public void watch(Character character) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }


    @Override
    public String getName() {
        return CodeColor.VIOLET + super.getName() + CodeColor.NONCOLOR;
    }

    public void walk(Place newLocation) {
        String message;

        if (newLocation == null) {
            message = String.format(this.getName() + " остался в %s... ", this.getLocation());
        } else {
            message = String.format("А " + this.getName() + " взял путь прямо из %s в %s! ", this.getLocation(), newLocation.getName());
            this.setLocation(newLocation);
        }

        System.out.print(message);
    }


}
