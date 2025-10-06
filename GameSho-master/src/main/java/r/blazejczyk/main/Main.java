package r.blazejczyk.main;
import r.blazejczyk.game.*;
import r.blazejczyk.customer.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Manager manager = new Manager("Sylvie");

        //Count discount
        Discount discount = new Discount(10); // 10% discount

        //Create games
        Type mario = new Type("Mario", 50.00, ConsoleType.NINTENDO, 2020, 101, 1, 8);
        Type lemmings = new Type("Lemmings", 40.00, ComputerType.AMIGA, 1991, 102, 2, 3);
        Type zelda = new Type("Zelda", 70.00, ConsoleType.NINTENDO, 2021, 103, 3, 2);

        //Add games to inventory
        inventory.addGame(mario);
        inventory.addGame(lemmings);
        inventory.addGame(zelda);

        //Display inventory before discounts
        System.out.println("\n====================Inventory before discount");
        manager.displayInventory(inventory);
        manager.buyGame(inventory, mario, 2);



        //Customer trades in a game
        Customer customer = new Customer(1, "Robert", "123 Street");
        TradeIn trade = new TradeIn(1, new Date());
        customer.makeTransaction(trade, inventory, mario);


//Customer makes a purchase
        Purchase purchase = new Purchase(2, new Date(), false);
        customer.makeTransaction(purchase, inventory, zelda);

        //List inventory again
        System.out.println("\n==================Inventory after transactions");
        manager.displayInventory(inventory);
    }
}