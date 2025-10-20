package r.blazejczyk.customer;

import java.util.ArrayList;
import java.util.Date;

public class TradeIn extends Transaction {
    private ArrayList<Transaction> relatedTransactions;

    /**
     *
     * @param transactionID
     * @param date
     */
    public TradeIn(int transactionID, Date date) {
        super(transactionID, "TradeIn", date);
        relatedTransactions = new ArrayList<>();
    }

    @Override
    public void processTransaction() {
        System.out.println("Processing trade-in transaction ID " + transactionID);
    }

    public void storeTransaction(Transaction transaction) {
        relatedTransactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactions() {
        return relatedTransactions;
    }
}