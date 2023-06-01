import java.util.ArrayList;

public class Order {
    ArrayList<Fruit> fruits;
    ArrayList<Double> quantityInKg;
    Buyer buyer;
    Seller seller;

    public Order(ArrayList<Fruit> fruits, ArrayList<Double> quantityInKg, Buyer buyer, Seller seller) {
        this.fruits = fruits;
        this.quantityInKg = quantityInKg;
        this.buyer = buyer;
        this.seller = seller;
    }
}
