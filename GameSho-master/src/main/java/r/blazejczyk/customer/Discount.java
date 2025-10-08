package r.blazejczyk.customer;

public class Discount {
    private double percentage;
    private boolean isApplied;

    public Discount(double percentage) {
        this.percentage = percentage;
        this.isApplied = false;
    }

    public double applyDiscount(double amount) {
        if (!isApplied) {
            isApplied = true;
            double discounted = amount - (amount * percentage / 100);
            return discounted;
        }
        return amount;
    }

    public boolean isApplied() { return isApplied; }
    public void markAsUsed(boolean used) { this.isApplied = used; }

    //Always return formatted string with 2 decimals
    public String createDecimals(double amount) {
        double discounted = applyDiscount(amount);
        return String.format("£%.2f", discounted); // always shows two decimals
    }
}
