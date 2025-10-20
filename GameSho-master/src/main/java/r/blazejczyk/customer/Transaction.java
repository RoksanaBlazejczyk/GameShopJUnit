package r.blazejczyk.customer;

import java.util.Date;



public abstract class Transaction {
    protected int transactionID;
    protected String type;
    protected Date date;

    /**
     *
     * @param transactionID
     * @param type
     * @param date
     */
    public Transaction(int transactionID, String type, Date date) {
        this.transactionID = transactionID;
        this.type = type;
        this.date = date;
    }

    public abstract void processTransaction();

    public String getType() { return type; }
    public int getTransactionID() { return transactionID; }
    public Date getDate() { return date; }
}

