package r.blazejczyk.game;

public abstract class Game {
    private int gameID;
    private double price;
    private String name;
    private int yearOfRelease;
    private int stockID;
    private int quantity;
    private String console; // store console or computer type as string

    public Game(String name, double price, String console, int yearOfRelease, int gameID, int stockID, int quantity) {
        this.name = name;
        this.price = price;
        this.console = console;
        this.yearOfRelease = yearOfRelease;
        this.gameID = gameID;
        this.stockID = stockID;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getConsole() {
        return console;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public boolean setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return false;
        } else if (quantity > 10) {
            System.out.println("Cannot set quantity of " + getName() + " to " + quantity + ". Maximum allowed is 10.");
            return false;
        } else {
            this.quantity = quantity;
            return true;
        }
    }
    public String getFormattedPrice() {
        return String.format("£%.2f", this.price);
    }

    public void setPrice(double price) {
        if (price >= 0) this.price = price;
    }

    public String getDetails() {
        return "Game: " + name + " (" + console + ", " + yearOfRelease + ")" + " | Price: £" + price + " | Quantity: " + quantity;
    }
}