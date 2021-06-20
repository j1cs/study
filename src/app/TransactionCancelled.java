package app;

public class TransactionCancelled implements State {

    private VendingMachine vendingMachine;

    public TransactionCancelled(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        System.out.println("Can't collect cash when transaction is cancelled");
    }

    @Override
    public void dispenseChange(String productCode) {
        System.out.println("Can't dispense change when transaction is cancelled");
    }

    @Override
    public void dispenseItem(String productCode) {
        System.out.println("Can't dispense item when transaction is cancelled");
    }

    @Override
    public void cancelTransaction() {
        if (this.vendingMachine.getCollectedCash() > 0)
            System.out.printf("Refunding collected cash $%d%n", this.vendingMachine.getCollectedCash());
        this.vendingMachine.setCollectedCash(0);
        this.vendingMachine.setState(new Ready(this.vendingMachine));
    }
}
