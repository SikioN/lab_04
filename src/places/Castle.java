package places;

final public class Castle extends Place {

    private Castle(final Builder builder) {
        super(builder);
    }

    public static class Builder2 extends Builder {
        public Builder2(String name) {
            super(name, 100.0);
        }

        @Override
        public Castle build() {
            return new Castle(this);
        }
    }

}
