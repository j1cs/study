package app.model;

public class Pepsi implements Product {
    private String name;
    private int price;

    public Pepsi(String name, int price) {
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

    public static PepsiBuilder builder() {
        return new PepsiBuilder();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Pepsi{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static class PepsiBuilder {
        private String name;
        private int price;

        public PepsiBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PepsiBuilder price(int price) {
            this.price = price;
            return this;
        }

        public Pepsi build() {
            return new Pepsi(name, price);
        }
    }
}
