package app;

public class Menu {
    public boolean isRunning;
    public String[] items;

    public Menu() {
        this.isRunning = true;
        this.items = new String[]{"show all", "add", "edit"};
    }

    public void run() {

    }
}
