package places;

import types.TimeOfDay;

public class Moon extends Place {


    private Moon(final Place.Builder builder) {
        super(builder);
    }

    public static class Builder2 extends Place.Builder {
        public Builder2(String name) {
            super(name, Double.POSITIVE_INFINITY);
            this.time = String.valueOf(TimeOfDay.NIGHT);
        }

        @Override
        public Moon build() {
            return new Moon(this);
        }
    }
}
