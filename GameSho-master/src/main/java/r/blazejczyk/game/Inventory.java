package r.blazejczyk.game;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Game> games;

    public Inventory() {
        games = new ArrayList<>();
    }

    public boolean addGame(Game newGame) {
        for (Game g : games) {
            if (g.getName().equals(newGame.getName()) && g.getConsole().equals(newGame.getConsole())) {
                int totalQty = g.getQuantity() + newGame.getQuantity();
                if (totalQty > 10) {
                    System.out.println("Cannot add " + newGame.getName() + ": would exceed maximum stock of 10.");
                    return false;
                }
                g.setQuantity(totalQty);
                System.out.println("Updated " + g.getName() + " quantity to " + g.getQuantity());
                return true;
            }
        }

        if (newGame.getQuantity() > 10) {
            System.out.println("Cannot add " + newGame.getName() + ": quantity exceeds maximum of 10.");
            return false;
        }

        games.add(newGame);
        return true;
    }

    public boolean removeGame(Game game, int qty) {
        for (Game g : games) {
            if (g.getName().equals(game.getName()) && g.getConsole().equals(game.getConsole())) {
                if (g.getQuantity() >= qty) {
                    g.setQuantity(g.getQuantity() - qty);
                    System.out.println("Removed " + qty + " of " + g.getName() + ". Remaining: " + g.getQuantity());
                    return true;
                } else {
                    System.out.println("Not enough stock to remove " + qty + " of " + g.getName());
                    return false;
                }
            }
        }
        System.out.println("Game not found: " + game.getName());
        return false;
    }

    public void listAllGames() {
        System.out.println("Inventory:");
        if (games.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Game g : games) {
                System.out.println(g.getDetails());
            }
        }
    }

    public ArrayList<Game> getGames() {
        return games;
    }
}
