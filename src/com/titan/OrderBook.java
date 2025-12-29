package com.titan;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class OrderBook {

    // 1. The Data Structures
    // The "Telephone Directory" for fast lookups (O(1))
    public Map<Integer, Order> orderMap = new HashMap<>();

    // The "Sorting Bins" for matching (O(log n))
    public PriorityQueue<Order> buyOrders = new PriorityQueue<>(
            Comparator.comparingDouble((Order o) -> o.price).reversed() // Highest Price First
    );

    public PriorityQueue<Order> sellOrders = new PriorityQueue<>(
            Comparator.comparingDouble((Order o) -> o.price)            // Lowest Price First
    );

    // --- METHOD 1: Add Order ---
    public void addOrder(Order newOrder) {
        // Step A: Add to the Directory so we can find it later
        if (orderMap.containsKey(newOrder.id)) {
            System.out.println("Error: Order ID " + newOrder.id + " already exists.");
            return;
        }
        orderMap.put(newOrder.id, newOrder);

        // Step B: Add to the Queue (Sorting happens automatically)
        if (newOrder.side.equals("BUY")) {
            buyOrders.add(newOrder);
        } else {
            sellOrders.add(newOrder);
        }

        // Step C: Check for matches immediately
        match();
    }

    // --- METHOD 2: Cancel Order (NEW) ---
    public void cancelOrder(int orderId) {
        // Step A: Look up the order in the directory (Instant speed)
        Order order = orderMap.get(orderId);

        // Step B: Check if it exists and is still valid
        if (order != null && order.isActive) {
            order.isActive = false; // Soft Delete (Mark as dead)
            orderMap.remove(orderId); // Remove from directory so we can't cancel again
            System.out.println("Order #" + orderId + " cancelled successfully.");
        } else {
            System.out.println("Order #" + orderId + " not found or already executed.");
        }
    }

    // --- METHOD 3: The Matching Engine ---
    public void match() {
        // CLEANUP PHASE: Remove "Dead" (cancelled) orders from the top of the piles
        // We look at the top (.peek). If it's dead (!isActive), we throw it away (.poll).
        while (!buyOrders.isEmpty() && !buyOrders.peek().isActive) {
            buyOrders.poll();
        }
        while (!sellOrders.isEmpty() && !sellOrders.peek().isActive) {
            sellOrders.poll();
        }

        // SAFETY CHECK: Stop if either side is empty
        if (buyOrders.isEmpty() || sellOrders.isEmpty()) {
            return;
        }

        // PEEK: Look at the best prices
        Order bestBuy = buyOrders.peek();
        Order bestSell = sellOrders.peek();

        // MATCH CHECK
        if (bestBuy.price >= bestSell.price) {
            System.out.println("✅ MATCH FOUND!");
            System.out.println("   " + bestBuy.toString() + " matches " + bestSell.toString());

            // EXECUTE: Remove them from the queues
            buyOrders.poll();
            sellOrders.poll();

            // CLEANUP: Remove them from the Map too (they are done)
            orderMap.remove(bestBuy.id);
            orderMap.remove(bestSell.id);

            // RECURSION: Keep checking for more matches
            match();
        }
        // Note: The "No Match" print because it gets annoying with cancellations
    }
}