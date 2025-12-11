import java.util.ArrayList;

public class OrderBook {
    ArrayList<Order> buyOrders = new ArrayList<>();
    ArrayList<Order> sellOrders = new ArrayList<>();

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

    // --- METHOD 2: Match (The Engine) ---
    // This lives OUTSIDE addOrder, but inside the Class.
    public void match() {
        // SAFETY CHECK: We can only match if we have BOTH a Buy and a Sell.
        // If one list is empty, stop immediately.
        if (buyOrders.isEmpty() || sellOrders.isEmpty()) {
            return;
        }

        // 1. Get the Best Buy and Best Sell (First items in the list)
        Order bestBuy = buyOrders.get(0);
        Order bestSell = sellOrders.get(0);

        // 2. CHECK THE PRICES (The Logic)
        // A Trade happens if: Buy Price is HIGH enough to match Sell Price.
        if (bestBuy.price >= bestSell.price) {
            System.out.println("✅ MATCH FOUND!");
            System.out.println("   Buyer wants: $" + bestBuy.price);
            System.out.println("   Seller wants: $" + bestSell.price);

            // Tier 1 logic: Remove them from the book (Simple version)
            buyOrders.remove(0);
            sellOrders.remove(0);
        } else {
            System.out.println("❌ No Match. Spread is too wide.");
        }
    }


}