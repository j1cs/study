package app;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        List<Coin> coins = Arrays.asList(
                Coin.builder().name("penny").value(1).build(),
                Coin.builder().name("nickel").value(5).build(),
                Coin.builder().name("dime").value(10).build(),
                Coin.builder().name("quarter").value(25).build()
        );

        List<Product> products = Arrays.asList(
                Product.builder().name("Coke").price(25).build(),
                Product.builder().name("Pepsi").price(35).build(),
                Product.builder().name("Soda").price(45).build()
        );

        List<String> coinList = coins.stream().map(coin -> String.valueOf(coin.getValue())).collect(Collectors.toList());
        Scanner scanned = new Scanner(System.in);
        String option = "0";
        int coin = 0;
        clean();
        while(true) {
            System.out.println("**************Welcome!**************");
            System.out.println("You can choose:");
            for (Product p : products) {
                System.out.printf("%s $%d%n", p.getName(), p.getPrice());
            }
            String acceptedCoins = String.join(",", coinList);
            System.out.println("Insert Coin");
            System.out.printf("We accepts: %s cents%n", acceptedCoins);
            while (true) {
                if (option.equalsIgnoreCase("n"))
                    break;
                if (coin >= 25 && option.equalsIgnoreCase("y"))
                    break;
                if (coin < 25 && option.equalsIgnoreCase("y")) {
                    System.out.println("You need to insert more coins to buy a product");
                }
                if (coinList.contains(option)) {
                    coin += Integer.parseInt(option);
                    System.out.printf("Credit $%s%n", coin);
                    System.out.print("You can add more coins or ");
                    System.out.println("if you want the product press \"y\"");
                } else if (!coinList.contains(option) && !option.equalsIgnoreCase("0")) {
                    if (coin > 0)
                        System.out.printf("Credit $%s%n", coin);
                    System.out.printf("We only accept: %s cents%n", acceptedCoins);
                }
                System.out.println("if you want to cancel press \"n\"");
                if (scanned.hasNext())
                    option = scanned.next();
            }
            int item = 0;
            clean();
            while (true) {
                if (option.equalsIgnoreCase("n")) {
                    if (coin > 0)
                        System.out.printf("Your refund $%d%n", coin);
                    coin = 0;
                    option = "0";
                    System.out.println("See ya!");
                    break;
                } else if (!option.equalsIgnoreCase("y") && (Integer.parseInt(option) <= 1 && Integer.parseInt(option) >= item)) {
                    System.out.println("Please select a valid option");
                } else if (!option.equalsIgnoreCase("y") && coin < products.get(Integer.parseInt(option) - 1).getPrice()) {
                    System.out.println("You don't have enough credits to buy this. Please choose another one");
                } else if (!option.equalsIgnoreCase("y") && coin >= products.get(Integer.parseInt(option) - 1).getPrice()) {
                    System.out.println("Great!");
                    System.out.printf("Here is your choice: %s%n", products.get(Integer.parseInt(option) - 1).getName());
                    int refund = coin - products.get(Integer.parseInt(option) - 1).getPrice();
                    if (refund > 0)
                        System.out.printf("Your refund $%d%n", refund);
                    coin = 0;
                    option = "0";
                    System.out.println("Thanks!");
                    break;
                }

                System.out.println("Choose ");
                for (int i = 0; i < products.size(); i++) {
                    item = i + 1;
                    System.out.printf("%d %s $%d%n", item, products.get(i).getName(), products.get(i).getPrice());
                }

                System.out.println("if you want to cancel press \"n\"");
                if (scanned.hasNext())
                    option = scanned.next();
            }
        }
    }

    private static void clean() {
        System.out.print("\u001b[2J" + "\u001b[H");
        System.out.flush();
    }
}
