package com.reconciler;

import com.reconciler.engine.ReconciliationEngine;

public class App {
    public static void main(String[] args) throws Exception {
        ReconciliationEngine.reconcile("sourceA.csv", "sourceB.csv");
    }
}

