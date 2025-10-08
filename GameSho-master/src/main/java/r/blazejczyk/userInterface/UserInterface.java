package r.blazejczyk.userInterface;

import r.blazejczyk.customer.*;
import r.blazejczyk.game.*;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class UserInterface {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        // Core objects
        Inventory inventory = new Inventory();
        Manager manager = new Manager("Sylvie");
        Customer customer = new Customer(1, "Robert", "123 Street");

        // Sample games
        Type mario = new Type("Mario", 50.00, ConsoleType.NINTENDO, 2020, 101, 1, 5);
        Type lemmings = new Type("Lemmings", 40.00, ComputerType.AMIGA, 1991, 102, 2, 3);
        Type zelda = new Type("Zelda", 70.00, ConsoleType.NINTENDO, 2021, 103, 3, 2);

        inventory.addGame(mario);
        inventory.addGame(lemmings);
        inventory.addGame(zelda);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n==============================");
            System.out.println("Welcome to Retro Game Shop!");
            System.out.println("==============================");
            System.out.println("1. View Inventory");
            System.out.println("2. Buy a Game");
            System.out.println("3. Trade In a Game");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.println("\n=== Current Inventory ===");
                    manager.displayInventory(inventory);
                    break;

                case 2:
                    System.out.print("Enter game name to buy: ");
                    String buyName = scanner.nextLine();
                    Type buyGame = findGameByName(inventory, buyName);

                    if (buyGame != null) {
                        double priceBefore = buyGame.getPrice();
                        customer.purchase(buyGame, inventory);
                        double pricePaid = buyGame.getPrice();
                        System.out.printf("%s purchased %s on %s | Price: £%.2f\n",
                                customer.getName(),
                                buyGame.getName(),
                                new Date(),
                                pricePaid);
                    } else {
                        System.out.println("Game not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter game name to trade in: ");
                    String tradeName = scanner.nextLine();
                    Type tradeGame = findGameByName(inventory, tradeName);

                    if (tradeGame != null) {
                        TradeIn trade = new TradeIn(new Random().nextInt(1000), new Date());
                        customer.makeTransaction(trade, inventory, tradeGame);
                        System.out.printf("%s traded in %s on %s | Price: £%.2f\n",
                                customer.getName(),
                                tradeGame.getName(),
                                new Date(),
                                tradeGame.getPrice());
                    } else {
                        System.out.println("Game not found in inventory! Try trading a known title.");
                    }
                    break;

                case 4:
                    System.out.println("\n=== Transaction History ===");
                    if (customer.getTransactionHistory().isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        for (String record : customer.getTransactionHistory()) {
                            System.out.println(record);
                        }
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Thanks for visiting Retro Game Shop!");
                    break;

                default:
                    System.out.println("Invalid choice! Please pick between 1–5.");
            }
        }

        scanner.close();
    }

    private static Type findGameByName(Inventory inventory, String name) {
        for (Game game : inventory.getGames()) {
            if (game.getName().equalsIgnoreCase(name) && game instanceof Type) {
                return (Type) game;
            }
        }
        return null;
    }
}
