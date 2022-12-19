package places;

import types.TimeOfDay;

final public class DreamWorld extends Place{
    private DreamWorld(final Builder builder) {
        super(builder);
    }

    public static class Builder2 extends Builder {

        public Builder2(String name) {
            super(name, Double.POSITIVE_INFINITY);
            this.time = String.valueOf(TimeOfDay.AFTERNOON);
        }

        @Override
        public DreamWorld build() {
            return new DreamWorld(this);
        }
    }
}
