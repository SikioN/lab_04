package characters;

import myexception.FellOutOfTheWorld;
import places.Deep;
import places.Place;
import utilities.CodeColor;
import utilities.Color;

final public class Stranger extends Character {


    public Stranger(String name, Color color) {
        super((name != null && color != null) ? CodeColor.values()[color.ordinal()].getTitle() + "" + color + " " + name + CodeColor.NONCOLOR
                : (name == null && color != null) ? CodeColor.values()[color.ordinal()].getTitle() + "" + color + " " + "Незнакомец" + CodeColor.NONCOLOR
                : (name != null) ? Color.NONCOLOR + " " + name + CodeColor.NONCOLOR
                : Color.NONCOLOR + " " + "Незнакомец" + CodeColor.NONCOLOR,
                new Deep.Builder2().build());
    }

    @Override
    public void walk(Place newLocation) {
        String message;

        if (newLocation == null) {
            throw new FellOutOfTheWorld(this.getName());
        } else {
            message = String.format(this.getName() + " пришёл из %s в %s ", this.getLocation(), newLocation.getName());
            this.setLocation(newLocation);
        }
        System.out.print(message);
    }

    public String lay() {
        return String.format("и лежит в %s.", this.getLocation());
    }
}
