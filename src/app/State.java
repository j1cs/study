package app;

public interface State {
    void collectCash(int cash);

    void dispenseChange(String productCode);

    void dispenseItem(String productCode);

    void cancelTransaction();
}
