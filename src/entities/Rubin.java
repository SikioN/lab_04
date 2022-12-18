package entities;

import characters.Character;
import places.Place;
import utilities.CodeColor;
import utilities.Color;

import java.util.Objects;

public class Rubin extends Entity {
    private Character owner;

    public Rubin(String name, Place place, Character owner) {
        super(CodeColor.RED + "" + Color.RED + " " + name + CodeColor.NONCOLOR, place);
        this.owner = owner;
    }

    public void setOwner(Character owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner.getName();
    }

    @Override
    public String toString() {
        return String.format("%s принадлежит %s. ", this.getName(), this.getOwner());
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
