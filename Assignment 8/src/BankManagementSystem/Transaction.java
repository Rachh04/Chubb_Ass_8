package BankManagementSystem;

import java.util.Date;

public class Transaction {
    private static int transactionCounter = 0;
    private final int transactionId;
    private final Date transactionDate;
    private final String transactionType;
    private final double transactionAmount;

    public Transaction(String transactionType, double transactionAmount) {
        this.transactionId = ++transactionCounter;
        this.transactionDate = new Date();
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
               ", Date: " + transactionDate +
               ", Type: " + transactionType +
               ", Amount: " + transactionAmount;
    }
}
