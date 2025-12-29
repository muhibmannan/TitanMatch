package com.titan;

public class Order implements Comparable<Order> {
    // 1. The Data Fields
    public int id;
    public double price;
    public int quantity;
    public String side; // "BUY" or "SELL"

    // NEW: The "Active" Switch (True = Alive, False = Cancelled)
    public boolean isActive;

    // 2. The Constructor
    public Order(int id, double price, int quantity, String side) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.isActive = true; // Default to Alive
    }

    // 3. The Sorting Logic (For PriorityQueue)
    // Returns -1 if this is "smaller", 1 if "bigger", 0 if equal
    @Override
    public int compareTo(Order other) {
        if (this.price < other.price) {
            return -1;
        } else if (this.price > other.price) {
            return 1;
        } else {
            return 0;
        }
    }

    // Optional: Useful for printing cleanly to console
    @Override
    public String toString() {
        return "[" + side + " #" + id + " @ $" + price + "]";
    }
}