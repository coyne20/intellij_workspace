package com.reconciler.model;

import java.math.BigDecimal;

public class TransactionAggregate {
    private String id;
    private String date;
    private BigDecimal totalAmount;
    private String source; // A or B

    public TransactionAggregate(String id, String date) {
        this.id = id;
        this.date = date;
        this.totalAmount = BigDecimal.ZERO;
    }

    public void addAmount(BigDecimal amount) {
        this.totalAmount = this.totalAmount.add(amount);
    }

    public String getId() { return id; }
    public String getDate() { return date; }
    public BigDecimal getTotalAmount() { return totalAmount; }

    public void setSource(String source) { this.source = source; }
    public String getSource() { return source; }

    @Override
    public String toString() {
        return id + "," + totalAmount + "," + date + "," + source;
    }
}


