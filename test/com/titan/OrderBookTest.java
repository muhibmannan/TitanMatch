package com.titan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderBookTest {

    @Test
    void testStandardMatch() {
        // 1. Setup the Engine
        OrderBook book = new OrderBook();

        // 2. Add a Sell Order (Seller wants $100)
        // Note: Using '2' as ID, 100.0 as price, 10 quantity
        Order sellOrder = new Order(2, 100.0, 10, "SELL");
        book.addOrder(sellOrder);

        // 3. Add a Buy Order (Buyer pays $100)
        Order buyOrder = new Order(3, 100.0, 10, "BUY");
        book.addOrder(buyOrder);

        // 4. VERIFY (The Assertion)
        // We expect the buy order to be filled (quantity 0)
        // We expect the sell order to be filled (quantity 0)
        // Note: This relies on your logic removing/reducing quantity!

        // If you implemented quantity reduction:
        // assertEquals(0, buyOrder.quantity, "Buyer should be empty");

        // If you just remove from list, we can check if the list is empty?
        // Since your variables are package-private, we can inspect them:
        assertTrue(book.buyOrders.isEmpty(), "Buy book should be empty after match");
        assertTrue(book.sellOrders.isEmpty(), "Sell book should be empty after match");
    }
}