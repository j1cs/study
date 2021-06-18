package app;

public class Coin {
    private int value;
    private String name;

    public Coin(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CoinBuilder builder() {
        return new CoinBuilder();
    }

    public static class CoinBuilder {
        private int value;
        private String name;

        public CoinBuilder value(int value) {
            this.value = value;
            return this;
        }

        public CoinBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Coin build() {
            return new Coin(value, name);
        }
    }
}
