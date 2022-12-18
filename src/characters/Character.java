package characters;

import entities.Entity;
import myexception.FellOutOfTheWorld;
import myexception.UnsupportedMethod;
import places.Place;

import java.util.Objects;

public abstract class Character {

    final private String name;
    private Place location;

    public Character(String name, Place location) throws FellOutOfTheWorld {
        this.name = Objects.requireNonNullElse(name, "Безымянный герой");
//        this.location = Objects.requireNonNullElseGet(location, Void::new);
        if (location == null) {
            throw new FellOutOfTheWorld(name);
        }
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public final Place getLocation() {
        return location;
    }

    public final void setLocation(Place location) {
        this.location = location;
    }

    public void sit() {
        System.out.printf("\n%s сидит в %s.\n", this.getName(), this.getLocation());
    }

    public final void sit(Character character) {
        System.out.printf("%s сидит около %s. ", this.getName(), character.getName());
    }


    abstract public void jump(Place newLocation) throws UnsupportedMethod;

    abstract public void watch(Entity entity) throws UnsupportedMethod;

    abstract public void watch(Character character) throws UnsupportedMethod;

    abstract public void walk(Place newLocation) throws UnsupportedMethod;

    public String getRemember(String about) {
        return null;
    }

    public void remember() throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }

    public void voiceLine(String message) {
        if (message == null) {
            System.out.printf("\n— ... — промолчал %s. ", this.getName());
        } else {
            System.out.printf("\n— %s! — сказал %s. ", message, this.getName());
        }
    }

    public String voiceLine() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s из %s", name, location.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Character other)) return false;
        return this.getLocation().equals(other.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLocation());
    }
}
