package app.model;


public class Coke implements Product {
    private String name;
    private int price;

    public Coke(String name, int price) {
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

    public static CokeBuilder builder() {
        return new CokeBuilder();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Coke{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static class CokeBuilder {
        private String name;
        private int price;

        public CokeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CokeBuilder price(int price) {
            this.price = price;
            return this;
        }

        public Coke build() {
            return new Coke(name, price);
        }
    }
}
