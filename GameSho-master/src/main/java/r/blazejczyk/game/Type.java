package r.blazejczyk.game;

public class Type extends Game {
    private Enum<?> type;

    //ConsoleType or ComputerType
// Constructor with price
    public Type(String name, double price, Enum<?> type, int yearOfRelease, int gameID, int stockID, int quantity) {
        super(name, price, type.name(), yearOfRelease, gameID, stockID, quantity);
        this.type = type;
    }

    public Enum<?> getType() {
        return type;
    }

    @Override
    public String getDetails() {
        return "Game: " + getName() + " (" + type.name() + ", " + getYearOfRelease() + ")" + " | Price: £" + getPrice() + " | Quantity: " + getQuantity();
    }
}