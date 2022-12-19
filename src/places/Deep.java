package places;

final public class Deep extends Place {
    public Deep(final Builder builder) {
        super(builder);
    }

    public static class Builder2 extends Builder {
        public Builder2() {
            super("Бездна", Double.NEGATIVE_INFINITY);
        }

        @Override
        public Deep build() {
            return new Deep(this);
        }
    }
}
