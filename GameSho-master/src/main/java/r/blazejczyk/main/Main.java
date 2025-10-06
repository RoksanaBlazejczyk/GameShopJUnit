package r.blazejczyk.main;

import r.blazejczyk.game.*;
import r.blazejczyk.customer.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Manager manager = new Manager("Sylvie");

        //Create games
        Type mario = new Type("Mario", 50.00, ConsoleType.NINTENDO, 2020, 101, 1, 7);
        Type lemmings = new Type("Lemmings", 40.00, ComputerType.AMIGA, 1991, 102, 2, 3);
        Type zelda = new Type("Zelda", 70.00, ConsoleType.NINTENDO, 2021, 103, 3, 2);

        //Add games to inventory
        inventory.addGame(mario);
        inventory.addGame(lemmings);
        inventory.addGame(zelda);

        //Display inventory before actions
        System.out.println("\n==================== Inventory before transactions ====================");
        manager.displayInventory(inventory);

        //Manager buys a game
        boolean bought = manager.buyGame(inventory, mario, 2);
        System.out.println("Manager " + manager.getName() + (bought
                ? " successfully bought " + mario.getName()
                : " could not buy " + mario.getName() + " (inventory full or invalid quantity)."));

        //Customer actions
        Customer customer = new Customer(1, "Robert", "123 Street");

        TradeIn trade = new TradeIn(1, new Date());
        customer.makeTransaction(trade, inventory, mario);
        System.out.println(customer.getName() + " traded in " + mario.getName());

        Purchase purchase = new Purchase(2, new Date(), false);
        customer.makeTransaction(purchase, inventory, zelda);
        System.out.println(customer.getName() + " purchased " + zelda.getName());

        //Final inventory
        System.out.println("\n==================== Inventory after transactions ====================");
        manager.displayInventory(inventory);
    }
}
