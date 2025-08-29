package com.reconciler.engine;

import com.reconciler.model.TransactionAggregate;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class ReconciliationEngine {

    // Load & aggregate by ID + Date
    private static Map<String, TransactionAggregate> loadAndAggregate(String file, String sourceLabel) throws IOException {
        Map<String, TransactionAggregate> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                BigDecimal amount = new BigDecimal(parts[1]);
                String date = parts[2];

                String key = id + "|" + date;
                map.putIfAbsent(key, new TransactionAggregate(id, date));
                map.get(key).addAmount(amount);
                map.get(key).setSource(sourceLabel);
            }
        }
        return map;
    }

    public static void reconcile(String fileA, String fileB) throws IOException {
        Map<String, TransactionAggregate> mapA = loadAndAggregate(fileA, "A");
        Map<String, TransactionAggregate> mapB = loadAndAggregate(fileB, "B");

        int matchedCount = 0;
        int unmatchedCount = 0;
        BigDecimal totalDifference = BigDecimal.ZERO;

        try (BufferedWriter matchedWriter = new BufferedWriter(new FileWriter("matched_report.csv"));
             BufferedWriter unmatchedWriter = new BufferedWriter(new FileWriter("unmatched_report.csv"))) {

            matchedWriter.write("ID,TotalAmount,Date\n");
            unmatchedWriter.write("ID,TotalAmount,Date,Source,Difference\n");

            // Compare A against B
            for (String key : mapA.keySet()) {
                TransactionAggregate aggA = mapA.get(key);
                TransactionAggregate aggB = mapB.remove(key);

                if (aggB != null) {
                    // Both present → compare
                    if (aggA.getTotalAmount().compareTo(aggB.getTotalAmount()) == 0) {
                        matchedWriter.write(aggA.getId() + "," + aggA.getTotalAmount() + "," + aggA.getDate());
                        matchedWriter.newLine();
                        matchedCount++;
                    } else {
                        // Difference case
                        BigDecimal diff = aggA.getTotalAmount().subtract(aggB.getTotalAmount()).abs();
                        unmatchedWriter.write(aggA.toString() + "," + diff);
                        unmatchedWriter.newLine();
                        unmatchedWriter.write(aggB.toString() + "," + diff);
                        unmatchedWriter.newLine();
                        unmatchedCount += 2;
                        totalDifference = totalDifference.add(diff);
                    }
                } else {
                    // Only in A
                    unmatchedWriter.write(aggA.toString() + "," + aggA.getTotalAmount());
                    unmatchedWriter.newLine();
                    unmatchedCount++;
                    totalDifference = totalDifference.add(aggA.getTotalAmount());
                }
            }

            // Remaining in B = unmatched
            for (TransactionAggregate aggB : mapB.values()) {
                unmatchedWriter.write(aggB.toString() + "," + aggB.getTotalAmount());
                unmatchedWriter.newLine();
                unmatchedCount++;
                totalDifference = totalDifference.add(aggB.getTotalAmount());
            }

            // Append total difference summary
            unmatchedWriter.write(",,,,TOTAL DIFFERENCE," + totalDifference);
            unmatchedWriter.newLine();
        }

        // Write summary log
        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter("reconciliation_log.txt", true))) {
            logWriter.write("Execution Time: " + new Date() + "\n");
            logWriter.write("Matched Transactions: " + matchedCount + "\n");
            logWriter.write("Unmatched Transactions: " + unmatchedCount + "\n");
            logWriter.write("Total Difference: " + totalDifference + "\n");
            logWriter.write("------------------------------------------------\n");
        }
    }
}
