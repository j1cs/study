package app;

public class Ready implements State {
    private final VendingMachine vendingMachine;

    public Ready(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        this.vendingMachine.addCollectedCash(cash);
    }

    @Override
    public void dispenseChange(String productCode) {
        this.vendingMachine.setState(new DispenseChange(this.vendingMachine));
        this.vendingMachine.dispenseChange(productCode);
    }

    @Override
    public void dispenseItem(String productCode) {
        System.out.println("Transaction not initialed. Can't dispense item");
    }

    @Override
    public void cancelTransaction() {
        this.vendingMachine.setState(new TransactionCancelled(this.vendingMachine));
        this.vendingMachine.cancelTransaction();
    }
}
