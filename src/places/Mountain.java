package places;

final public class Mountain extends Place{

    private Mountain(final Builder builder) {
        super(builder);
    }

    public static class Builder2 extends Builder {
        public Builder2(String name) {
            super(name, 250.0);
        }

        @Override
        public Mountain build() {
            return new Mountain(this);
        }
    }
}
