package entities;

import myexception.FellOutOfTheWorld;
import places.Place;

import java.util.Objects;

public abstract class Entity {
    final private String name;
    private Place location;

    public Entity(String name, Place location) throws FellOutOfTheWorld {
        this.name = Objects.requireNonNullElse(name, "Ничто");
//        this.location = Objects.requireNonNullElseGet(location, Void::new);
        if (location == null) {
            throw new FellOutOfTheWorld(name);
        }
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Place getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return String.format("%s в %s", this.name, this.location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Entity other)) return false;
        return this.getLocation().getName().equals(other.getLocation().getName()) && this.getLocation().getClass().equals(other.getLocation().getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLocation());
    }
}
