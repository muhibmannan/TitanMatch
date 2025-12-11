public class Order {
    // 1. The Blueprint Variable (Fields)
    int id;
    double price;
    int quantity;
    String side;

    // 2. The Constructor (The Builder)
    public Order(int id, double price, int quantity, String side) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
    }
}
