package app.model;

public class Soda implements Product {
    private String name;
    private int price;

    public Soda(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static SodaBuilder builder() {
        return new SodaBuilder();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Soda{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static class SodaBuilder {
        private String name;
        private int price;

        public SodaBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SodaBuilder price(int price) {
            this.price = price;
            return this;
        }

        public Soda build() {
            return new Soda(name, price);
        }
    }
}