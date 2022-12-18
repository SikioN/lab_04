package characters;

import entities.Entity;
import places.Place;

abstract public class Moomins extends Character implements Remember {
    public Moomins(String name, Place location) {
        super(name, location);
    }

    @Override
    public void watch(Character character) {
        if (this.equals(character)) {
            this.voiceLine(String.format("Вот %s", character.getName()));
        } else {
            this.voiceLine("Ой... здесь никого нет.");
        }
    }

    @Override
    public void watch(Entity entity) {
        if (this.getLocation().equals(entity.getLocation())){
            this.voiceLine(String.format("Здесь %s", entity.getName()));
        } else {
            this.voiceLine("Ой... здесь ничего нет.");
        }
    }
}
