package places;

public class World extends Place{

    private World(final Builder builder) {
        super(builder);
    }

    public static class Builder2 extends Builder {
        public Builder2(String name) {
            super(name, Double.POSITIVE_INFINITY);
        }

        @Override
        public World build() {
            return new World(this);
        }
    }
}
