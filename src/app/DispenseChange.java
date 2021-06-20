package app;

public class DispenseChange implements State {

    private VendingMachine vendingMachine;

    public DispenseChange(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        System.out.println("Refunding change. Can't collect coins");
    }

    @Override
    public void dispenseChange(String productCode) {
        int refund = this.vendingMachine.calculateChange(productCode);
        System.out.printf("$%d refunded%n", refund);
        this.vendingMachine.setState(new DispenseItem(this.vendingMachine));
        this.vendingMachine.dispenseItem(productCode);
    }

    @Override
    public void dispenseItem(String productCode) {
        System.out.println("Refunding change. Can't dispense item");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Refunding change. Can't cancel transaction");
    }
}
