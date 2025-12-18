package com.titan;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderBook {

    // --- NEW CODE (The "Tier 1" Data Structure) ---

    // Rule for BUYs: Highest Price First (Descending Order)
    // If prices are equal, we don't care about time yet (Basic Version)
    PriorityQueue<Order> buyOrders = new PriorityQueue<>(
            Comparator.comparingDouble((Order o) -> o.price).reversed()
    );
    // Rule for SELLs: Lowest Price First (Ascending Order - Default)
    PriorityQueue<Order> sellOrders = new PriorityQueue<>(
            Comparator.comparingDouble((Order o) -> o.price)
    );

    // --- METHOD 1: Add Order ---
    public void addOrder(Order newOrder) {
        // 1. Add the new order to the correct list
        if (newOrder.side.equals("BUY")) {
            buyOrders.add(newOrder);
        } else {
            sellOrders.add(newOrder);
        }

        // 2. Immediately try to match!
        match();
    }

    // --- METHOD 2: Match (Updated) ---

    public void match() {
        // Same safety check
        if (buyOrders.isEmpty() || sellOrders.isEmpty()) {
            return;
        }

        // PEEK: Look at the top of the piles (Cheapest Sell / Richest Buy)
        Order bestBuy = buyOrders.peek(); // .peek() is 0(1) - Instant!
        Order bestSell = sellOrders.peek();

        // 2. CHECK PRICES
        if (bestBuy.price >= bestSell.price) {
            System.out.println("✅ MATCH FOUND!");
            System.out.println("   Buyer wants: $" + bestBuy.price);
            System.out.println("   Seller wants: $" + bestSell.price);

            // EXECUTE (The Upgrade)
            // .poll() removes the top item from the heap
            buyOrders.poll();
            sellOrders.poll();

            // RECURSION CHECK:
            // Since the order was removed, maybe the NEXT pair also matches?
            // Let's call match() to check the next in line
            match();
        } else {
            System.out.println("❌ No Match. Spread is too wide.");
        }
    }
}