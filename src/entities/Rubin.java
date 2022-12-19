package entities;

import characters.Character;
import places.Place;
import utilities.CodeColor;
import utilities.Color;

import java.util.Objects;

public class Rubin extends Entity {
    private final Character owner;

    public Rubin(Place place, Character owner, Color color) {
        super(CodeColor.values()[color.ordinal()].getTitle() + "" + color + " " + "Рубин" + CodeColor.NONCOLOR, place);
        this.owner = owner;
    }

    public String getOwner() {
        return owner.getName();
    }

    @Override
    public String toString() {
        return String.format("Самый большой %s находится в %s.", this.getName(), this.getLocation());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rubin rubin)) return false;
        if (!super.equals(o)) return false;
        return getOwner().equals(rubin.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOwner());
    }
}
