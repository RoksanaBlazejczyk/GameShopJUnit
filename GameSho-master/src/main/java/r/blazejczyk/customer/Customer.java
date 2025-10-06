package r.blazejczyk.customer;

import r.blazejczyk.game.Game;
import r.blazejczyk.game.Inventory;
import r.blazejczyk.game.Type;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerID;
    private String name;
    private String address;
    private boolean discountEligible;
    private List<String> transactionHistory;

    public Customer(int customerID, String name, String address) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.discountEligible = false;
        this.transactionHistory = new ArrayList<>();
    }
    public void makeTransaction(Transaction transaction, Inventory inventory, Type game) {
        if (transaction instanceof TradeIn) {
            tradeIn(game, inventory);
            transactionHistory.add("TradeIn transaction ID: " + transaction.getTransactionID());
        } else if (transaction instanceof Purchase) {
            purchase(game, inventory);
            transactionHistory.add("Purchase transaction ID: " + transaction.getTransactionID());
        }
    }

    // Trade-in 1 copy of a game
    public void tradeIn(Game game, Inventory inventory) {
        if (game == null) return;

        // Attempt to add 1 to inventory
        Game copy = new Type(((Type) game).getName(), game.getPrice(),
                ((Type) game).getType(), game.getYearOfRelease(),
                0, 0, 1);

        boolean added = inventory.addGame(copy);
        if (added) {
            discountEligible = true;
            transactionHistory.add("TradeIn: " + game.getName());

        } else {
            //System.out.println("\n"+name + " cannot trade in " + game.getName() + ": inventory full (10 max).");
        }
    }

    // Purchase 1 copy
    public void purchase(Game game, Inventory inventory) {
        if (game.getQuantity() <= 0) {
            System.out.println("Sorry, " + game.getName() + " is out of stock.");
            return;
        }

        boolean removed = inventory.removeGame(game, 1);
        if (!removed) return;

        String record = "Purchase: " + game.getName();
        if (discountEligible) {
            double discountedPrice = Math.round(game.getPrice() * 0.9 * 100.0) / 100.0;
            System.out.println("\n"+name + " purchased " + game.getName() + " with 10% discount (£" + discountedPrice + ")");
            record += " (10% discount)";
            discountEligible = false;
        } else {
            System.out.println("\n"+name + " purchased " + game.getName() + " (£" + game.getPrice() + ")");
        }

        transactionHistory.add(record);
    }

    // Getters
    public int getCustomerID() { return customerID; }
    public String getName() { return name; }
    public boolean isDiscountEligible() { return discountEligible; }
    public List<String> getTransactionHistory() { return transactionHistory; }
}
