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
            return Math.round(discounted * 100.0) / 100.0; // 2 decimals
        }
        return Math.round(amount * 100.0) / 100.0;
    }

    public boolean isApplied() { return isApplied; }
    public void markAsUsed(boolean used) { this.isApplied = used; }
}
