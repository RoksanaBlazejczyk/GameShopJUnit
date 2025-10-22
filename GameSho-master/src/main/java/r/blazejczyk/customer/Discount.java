package r.blazejczyk.customer;

public class Discount {
    private double percentage;
    private boolean isApplied;

    public Discount(double percentage) {
        this.percentage = percentage;
        this.isApplied = false;
    }

    /**
     *
     * @param amount
     * @return
     */
    public double applyDiscount(double amount) {
        if (!isApplied) {
            isApplied = true;
            double discounted = amount - (amount * percentage / 100);
            return discounted;
        }
        return amount;
    }



}
