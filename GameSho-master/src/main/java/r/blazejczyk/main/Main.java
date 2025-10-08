package r.blazejczyk.main;

import r.blazejczyk.game.*;
import r.blazejczyk.customer.*;
import r.blazejczyk.userInterface.UserInterface;


import java.util.Date;

public class Main {
    public static void main(String[] args) {
        UserInterface.run();

        Inventory inventory = new Inventory();

        Manager manager = new Manager("Sylvie");

        //Initialize file
        SaveToFile.writeToFile("inventory_report.txt", "Inventory Report\n====================\n");
        SaveToFile.appendToFile("inventory_report.txt", "Initial Inventory Created.\n");

        // Create games
        Type mario = new Type("Mario", 50.00, ConsoleType.NINTENDO, 2020, 101, 1, 7);
        Type lemmings = new Type("Lemmings", 40.00, ComputerType.AMIGA, 1991, 102, 2, 3);
        Type zelda = new Type("Zelda", 70.00, ConsoleType.NINTENDO, 2021, 103, 3, 2);

        // Add games to inventory
        inventory.addGame(mario);
        inventory.addGame(lemmings);
        inventory.addGame(zelda);

        //Manager buys a game
        manager.buyGame(inventory, mario, 2);

        //Customer trades and purchases
        Customer customer = new Customer(1, "Robert", "123 Street");

        TradeIn trade = new TradeIn(1, new Date());
        customer.makeTransaction(trade, inventory, mario);
        //when a customer purchases a game, use createDecimals()
        Discount discount = new Discount(10); // 10% discount
        Purchase purchase = new Purchase(2, new Date(), false);
        customer.makeTransaction(purchase, inventory, zelda);

        //Use createDecimals() to get a formatted string with two decimals:
        String discountedPrice = discount.createDecimals(zelda.getPrice());
        System.out.println(customer.getName() + " purchased " + zelda.getName()
                + " for " + discountedPrice + " (Qty: " + zelda.getQuantity() + ")");

        //When writing final inventory to file, format each price:
        SaveToFile.appendToFile("inventory_report.txt", "\nFinal Inventory:\n");
        for (Game game : inventory.getGames()) {

            String line = game.getName() + " - Quantity: " + game.getQuantity()
                    + " | Price: " + game.getFormattedPrice(); //use formatted price
            SaveToFile.appendToFile("inventory_report.txt", line + "\n");
        }
    }
}