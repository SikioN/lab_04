package places;

final public class Mumindalen extends Place{
    private Mumindalen(final Builder builder) {
        super(builder);
    }

    public static class Builder2 extends Place.Builder {
        public Builder2(String name) {
            super(name, 1000.0);
        }

        @Override
        public Mumindalen build() {
            return new Mumindalen(this);
        }
    }
}
