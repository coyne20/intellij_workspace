package com.reconciler.model;
public class Transaction {
    private String id;
    private double amount;
    private String date;

    public Transaction(String id, double amount, String date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction t = (Transaction) o;
        return Double.compare(t.amount, amount) == 0 &&
                id.equals(t.id) &&
                date.equals(t.date);
    }

    @Override
    public int hashCode() {
        return id.hashCode() + date.hashCode();
    }

    @Override
    public String toString() {
        return id + "," + amount + "," + date;
    }

    public static Transaction fromCsv(String line) {
        String[] parts = line.split(",");
        return new Transaction(parts[0], Double.parseDouble(parts[1]), parts[2]);
    }
}
