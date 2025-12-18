package com.titan;

public class Main {
    public static void main(String[] args) {
        OrderBook book = new OrderBook();

        // 1. A Seller arrives wanting !100
        book.addOrder(new Order(1, 100.00, 10, "SELL"));

        // 2. A "Cheap" Buyer arrives (offering $90)
        // In the old ArrayList, this guy would block the fron of the line!
        book.addOrder(new Order(2, 90.0, 10, "BUY"));

        System.out.println("--- Rich Buyer Arrives ---");

        // 3. A "Rich" Buyer arrives (offering $105)
        book.addOrder(new Order(3, 105.0, 10, "BUY"));

        // RESULT:
        // If we see "Buyer wants: $105", your PriorityQueue works!
        // If we see "No Match" (because $90 is stuck at top), it failed.
    }
}