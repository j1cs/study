package app;

public class DispenseItem implements State {
    private final VendingMachine vendingMachine;

    public DispenseItem(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        System.out.println("Dispensing item. Can't collect cash");
    }

    @Override
    public void dispenseChange(String productCode) {
        System.out.println("Dispensing item. Can't dispense cash");
    }

    @Override
    public void dispenseItem(String productCode) {
        int coins = this.vendingMachine.getCollectedCash();
        int price = this.vendingMachine.getProductPrices().get(productCode);
        String product = this.vendingMachine.getProductItems().get(productCode);
        if (coins >= price) {
            System.out.printf("Dispensing %s%n", product);
            this.vendingMachine.setCollectedCash(0);
            this.vendingMachine.setState(new Ready(vendingMachine));
        } else {
            System.out.printf("You don't have enough cash: $%d for the product $%d. Please insert more%n", coins, price);
        }
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Dispensing item. Can't cancel transaction");
    }
}
