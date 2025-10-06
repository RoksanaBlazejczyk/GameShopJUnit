package r.blazejczyk.game;

import java.util.ArrayList;

public class Manager {
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    //Display all games in an inventory
    public void displayInventory(Inventory inventory) {
        System.out.println("\nManager " + name + " is displaying inventory:");
        inventory.listAllGames();
    }

    public void displayGames(ArrayList<Game> games) {
        System.out.println("\nManager " + name + " is displaying selected games:");
        for (Game game : games) {
            System.out.println(game.getDetails());
        }
    }

    //Manager buys a game for the shop
    public void buyGame(Inventory inventory, Game newGame, int quantity) {
        if (quantity <= 0) {
            System.out.println("Cannot buy zero or negative quantity.");
            return;
        }

        //Create a temporary copy of the game with the desired quantity
        Game gameToAdd;
        if (newGame instanceof Type) {
            Type t = (Type) newGame;
            gameToAdd = new Type(t.getName(), t.getPrice(), t.getType(), t.getYearOfRelease(), 0, 0, quantity);
        } else {
            // fallback for base Game (if needed)
            gameToAdd = newGame;
        }

        boolean added = inventory.addGame(gameToAdd);
        if (added) {
            System.out.println("\nManager " + name + " bought " + gameToAdd.getQuantity() + " of " + newGame.getName());
        } else {
            System.out.println("\nManager " + name + " could not buy " + newGame.getName() + ". Inventory limit reached (10 max).");
        }
    }
}
