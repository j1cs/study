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
        System.out.println("Welcome!");
        System.out.println("You can choose:");
        for (Product p : products) {
            System.out.printf("%s $%d%n", p.getName(), p.getPrice());
        }
        String acceptedCoins = String.join(",", coinList);
        System.out.println();
        Scanner scanned = new Scanner(System.in);
        System.out.println("Insert Coin");
        System.out.printf("We accepts: %s cents%n", acceptedCoins);
        String option = "0";
        int coin = 0;
        while (true) {
            if (option.equalsIgnoreCase("n")) {
                System.out.println("See ya!");
                if (coin > 0)
                    System.out.printf("Your refund $%d%n", coin);
                break;
            }

            if (coin >= 25 && option.equalsIgnoreCase("y"))
                break;
            if (coin < 25 && option.equalsIgnoreCase("y")) {
                System.out.println("You need to insert more coins to buy a product");
                System.out.printf("Credit $%s%n", coin);
            }
            if (coinList.contains(option)) {
                coin += Integer.parseInt(option);
                System.out.printf("Credit $%s%n", coin);
                System.out.print("You can add more coins or ");
                System.out.println("if you want the product press \"y\"");
            }
            if (!coinList.contains(option) && !option.equalsIgnoreCase("0")) {
                if (coin > 0)
                    System.out.printf("Credit $%s%n", coin);
                System.out.printf("We only accept: %s cents%n", acceptedCoins);
            }
            System.out.println("if you want to cancel press \"n\"");
            if (scanned.hasNext())
                option = scanned.next();
        }
        int item = 0;
        while (true) {
            if (option.equalsIgnoreCase("n")) {
                System.out.println("See ya!");
                if (coin > 0)
                    System.out.printf("Your refund $%d%n", coin);
                break;
            } else if (!option.equalsIgnoreCase("y") && (item <= Integer.parseInt(option) && Integer.parseInt(option) >= item)) {
                System.out.println("Please select a valid option");
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

    private static void clean() {
        System.out.print("\u001b[2J" + "\u001b[H");
        System.out.flush();
    }
}
