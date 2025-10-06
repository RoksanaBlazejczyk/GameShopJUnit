package r.blazejczyk.customer;

import java.util.Date;

public class Purchase extends Transaction {
    private boolean discountApplied;

    public Purchase(int transactionID, Date date, boolean discountApplied) {
        super(transactionID, "Purchase", date);
        this.discountApplied = discountApplied;
    }

    @Override
    public void processTransaction() {
        System.out.println("Processing purchase transaction ID " + transactionID + ". Discount applied: " + discountApplied);
    }

    public boolean isDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(boolean applied) {
        this.discountApplied = applied;
    }
}