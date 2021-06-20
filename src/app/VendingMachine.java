package app;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VendingMachine {
    private int collectedCash;
    private State state;
    private List<Integer> acceptedCash = Arrays.asList(1, 5, 10, 25);
    private Map<String, String> productItems = new LinkedHashMap<>((Map.of("A1", "Coke", "B2", "Pepsi", "C3", "Soda")));
    private Map<String, Integer> productPrices = Map.of("A1", 25, "B2", 35, "C3", 45);

    private static VendingMachine vendingMachine = new VendingMachine();

    public VendingMachine() {
    }

    public static VendingMachine getInstance() {
        return vendingMachine;
    }

    public List<Integer> getAcceptedCash() {
        return acceptedCash;
    }

    public Map<String, String> getProductItems() {
        return productItems;
    }

    public Map<String, Integer> getProductPrices() {
        return productPrices;
    }

    public void addCollectedCash(int collectedCash) {
        if (acceptedCash.contains(collectedCash)) {
            this.collectedCash += collectedCash;
        } else if (collectedCash > 0) {
            System.out.printf("Can't accept $%d. You can only add: %s cents%n", collectedCash, acceptedCash.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
    }

    public VendingMachine setCollectedCash(int collectedCash) {
        this.collectedCash = collectedCash;
        return this;
    }

    public State getState() {
        return state;
    }

    public VendingMachine setState(State state) {
        this.state = state;
        return this;
    }

    public void removeProduct(String productCode) {
    }

    public void dispenseChange(String productCode) {
        boolean exists = this.productItems.containsKey(productCode);
        if (exists) {
            int coins = vendingMachine.collectedCash;
            int price = vendingMachine.productPrices.get(productCode);
            if (coins >= price) {
                this.state.dispenseChange(productCode);
            } else {
                System.out.printf("You don't have enough cash: $%d for the product $%d. Please insert more%n", coins, price);
            }
        } else {
            System.out.printf("Product with code %s doesn't exists. Please choose another one%n", productCode);
        }

    }

    public void cancelTransaction() {
        this.state.cancelTransaction();
    }

    public int calculateChange(String name) {
        return collectedCash - productPrices.get(name);
    }

    public void dispenseItem(String productCode) {
        boolean exists = this.productItems.containsKey(productCode);
        if (exists) {
            this.state.dispenseItem(productCode);
        } else if (collectedCash > 0) {
            System.out.printf("Product with code %s doesn't exists. Please choose another one%n", productCode);
        }
    }

    public int getCollectedCash() {
        return collectedCash;
    }
}
