package app;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    private static final VendingMachine vendingMachine = VendingMachine.getInstance();

    public static void main(String[] args) {
        Scanner scanned = new Scanner(System.in);
        String option = null;
        String coinAccepted = vendingMachine.getAcceptedCash().stream().map(String::valueOf).collect(Collectors.joining(","));
        vendingMachine.setState(new Ready(vendingMachine));
        while (true) {
            if (vendingMachine.getCollectedCash() == 0) {
                System.out.println("**************Welcome!**************");
                System.out.println("You can choose:");
                printProducts();
                System.out.printf("We accept: %s cents%n", coinAccepted);
            } else {
                System.out.println("Select product:");
                printProducts();
            }
            System.out.println("if you want to cancel press \"n\"");
            System.out.println("Insert Coin:");
            if (scanned.hasNextInt()) {
                vendingMachine.addCollectedCash(scanned.nextInt());
                System.out.printf("Inserted $%d%n", vendingMachine.getCollectedCash());
            }
            if (scanned.hasNextLine())
                option = scanned.nextLine();
            if (option != null && option.equalsIgnoreCase("n")) {
                vendingMachine.cancelTransaction();
            }
            if (Pattern.matches("^[A-Z][0-9]$", option)) {
                vendingMachine.dispenseChange(option);
            }

        }
    }

    private static void printProducts() {
        vendingMachine.getProductItems().forEach((id, name) -> System.out.printf("%s. %-5s $%d%n", id, name, vendingMachine.getProductPrices().get(id)));
    }
}
