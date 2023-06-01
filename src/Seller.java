import java.util.ArrayList;

public class Seller extends User{
    String Address;
    ArrayList<Fruit> fruitList;

    public Seller(String firstName, String lastName, String phoneNumber, String address, ArrayList<Fruit> fruitList) {
        super(firstName, lastName, phoneNumber);
        this.Address = address;
        this.fruitList = fruitList;
    }

    public void display(){
        System.out.println();
        System.out.println(this.firstName+" "+this.lastName);
        System.out.println("Name\tVariety\tQuantity\tPrice");
        for(Fruit f:this.fruitList){
            System.out.println(f.name+"\t"+f.variety+"\t"+f.totalQuantityKg+"\t"+f.pricePerKg);
        }
    }
}
