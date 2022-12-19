package places;

import myexception.CantBeThere;
import types.TimeOfDay;
import utilities.CheckInformation;

import java.util.Objects;

public abstract class Place {

    public static abstract class Builder {
        private final String name;
        private final Double size;
        private String location;
        String time;

        public Builder(String name, Double size) {
            CheckInformation<String> checkName = (String s) -> {
                if (s == null || s.equals("")) {
                    return "Безымянное место";
                }
                return s;
            };
            this.name = checkName.check(name);

            this.size = size;
        }

        public Builder setTime() {
            this.time = String.valueOf(TimeOfDay.randomStyle());
            return this;
        }

        public Builder setLocation(Place location) {

            CheckInformation<Place> checkLocation = (Place s) -> {
                if (s == null || this.size > location.getSize() || this.size < 0) {
                    throw new CantBeThere(String.format("%s не может находится в этом месте", this.name));
                }
                return s;
            };

            this.location = checkLocation.check(location).getName();
            return this;
        }

        public abstract Place build();
    }

    private final String name;
    private final Double size;
    private final String location;
    private final String time;

    protected Place(final Builder builder) {
        this.name = builder.name;
        this.size = builder.size;
        this.location = builder.location;
        this.time = builder.time;
    }

    final public String getName() {
        return name;
    }

    public Double getSize() {
        return size;
    }

    final public String getLocation() {
        if (location == null) {
            World world = (World) new World.Builder2("Мир").setTime().build();
            return world.getName();
        }
        return location;
    }

    public String getTime() {
        if (time == null) {
            return String.valueOf(TimeOfDay.randomStyle());
        }
        return time;
    }

    @Override
    public String toString() {
        if (location != null) {
            return String.format("%s в %s", this.name, this.location);
        }
        return String.format("%s", this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Place place)) return false;
        return Objects.equals(getName(), place.getName()) && Objects.equals(location, place.location) && Objects.equals(getClass(), place.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), location);
    }

}
