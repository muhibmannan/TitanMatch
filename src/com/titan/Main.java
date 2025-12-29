package com.titan;

public class Main {
    public static void main(String[] args) {
        OrderBook book = new OrderBook();
        System.out.println("--- Market Open ---");

        // 1. Add a Buy Order for $100
        System.out.println("Adding Order #1 (Buy @ $100)");
        book.addOrder(new Order(1, 100.0, 10, "BUY"));

        // 2. Cancel it immediately
        System.out.println("\n--- Cancelling Order #1 ---");
        book.cancelOrder(1);

        // 3. Add a Sell Order for $100
        // In the old system, this would match.
        // In the new system, Order #1 is "dead", so nothing should happen.
        System.out.println("\n--- Adding Seller (Sell @ $100) ---");
        book.addOrder(new Order(2, 100.0, 10, "SELL"));

        // 4. Verification
        System.out.println("\nResult: If you see NO Match above, it worked.");
    }
}