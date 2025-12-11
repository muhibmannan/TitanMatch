public class Main {
    public static void main(String[] args) {
        OrderBook book = new OrderBook();

        // --- Scenario 1: DELETED (So the $90 guy doesn't block the line) ---

        // --- Scenario 2: The Perfect Match ---
        // 1. Add a Seller who wants $100
        book.addOrder(new Order(2, 100.00, 10, "SELL"));

        // 2. Add a Buyer who pays $100
        book.addOrder(new Order(3, 100.00, 10, "BUY"));
        // Result: Since this is the ONLY buyer, they are at the front (index 0).
        // The engine sees $100 vs $100 -> MATCH!
    }
}