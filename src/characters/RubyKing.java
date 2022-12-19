package characters;

import entities.Entity;
import myexception.FellOutOfTheWorld;
import places.Place;
import utilities.CodeColor;


final public class RubyKing extends Character {
    public RubyKing(String name, Place location) {
        super(name, location);
    }

    @Override
    public String getName() {
        return CodeColor.RUBIN + super.getName() + CodeColor.NONCOLOR;
    }

    @Override
    public void walk(Place newLocation) {
        String message;
        if (newLocation == null) {
            throw new FellOutOfTheWorld(this.getName());
        } else {
            message = String.format("%s побежал в %s! ", this.getName(), newLocation.getName());
            this.setLocation(newLocation);
        }
        System.out.print(message);
    }


    public void sparkling(Entity entity) {
        String message;
        if (entity == null) {
            message = String.format("%s ничего не держал...", this.getName());
        } else {
            int rate = -1 + (int) (Math.random() * 3);
            message = String.format("В руках у %s %s сверкал %s.", this.getName(), (rate > 0 ? "сильно" : "слабо"), entity.getName());
        }
        System.out.println(message);
    }
}
