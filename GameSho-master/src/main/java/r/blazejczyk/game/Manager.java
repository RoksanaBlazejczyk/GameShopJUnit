package r.blazejczyk.game;

import java.util.ArrayList;


public class Manager {
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    public void displayInventory(Inventory inventory) {
        System.out.println("\nManager " + name + " is displaying inventory:");
        inventory.listAllGames();
    }

    public void displayGames(ArrayList<Game> games) {
        for (Game game : games) {
            System.out.println(game.getDetails());
        }
    }

    /**
     *
     * @param inventory
     * @param newGame
     * @param quantity
     * @return
     */
    //Manager buys a game for the shop
    public boolean buyGame(Inventory inventory, Game newGame, int quantity) {
        if (quantity <= 0) {
            return false; //invalid quantity
        }

        Game gameToAdd;
        if (newGame instanceof Type) {
            Type t = (Type) newGame;
            gameToAdd = new Type(t.getName(), t.getPrice(), t.getType(), t.getYearOfRelease(), 0, 0, quantity);
        } else {
            gameToAdd = newGame;
        }

        return inventory.addGame(gameToAdd);
    }

    public String getName() {
        return name;
    }
}
