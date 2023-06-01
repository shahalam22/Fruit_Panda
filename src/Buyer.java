import java.util.ArrayList;
import java.util.Scanner;

public class Buyer extends User{
    String Address;
    double Rewards;
    Order order;

    public Buyer(String firstName, String lastName, String phoneNumber, String address, double rewards, Order order) {
        super(firstName, lastName, phoneNumber);
        this.Address = address;
        this.Rewards = rewards;
        this.order = order;
    }

    public Order placeOrder(Seller seller){
        Scanner input = new Scanner(System.in);

        //showing fruits available to the seller
        System.out.println("Fruit name\tVariety\tQuantity\tPrice/kg");
        for(int i=0; i<seller.fruitList.size(); i++){
            System.out.println(seller.fruitList.get(i).name+"\t"+seller.fruitList.get(i).variety+"\t"+seller.fruitList.get(i).totalQuantityKg+"\t"+seller.fruitList.get(i).pricePerKg);
        }

        ArrayList<Fruit> orderedFruit = new ArrayList<>();
        ArrayList<Double> orderedqntt = new ArrayList<>();

        System.out.println("How many types of fruit do you want to order?");
        int numOfF = input.nextInt();

        for(int i=0; i<numOfF; i++){
            System.out.println("Enter fruit name - ");
            String fName = input.next();
            System.out.println("Enter fruit variety - ");
            String vName = input.next();
            System.out.println("Enter quantity - ");
            double qntt = input.nextDouble();

            Fruit chkF = null;
            for(Fruit F : seller.fruitList){
                if(F.name.equals(fName) && F.variety.equals(vName)){
                    chkF = F;
                }
            }

            try{
                if(chkF == null) {
                    throw new NoFruitsException("Sorry!! Fruit not found.");
                }
                if (chkF.totalQuantityKg<qntt) {
                    throw new NoFruitsException("Sorry!! You can't order more than "+chkF.totalQuantityKg+".");
                }
                for(int j=0; j<seller.fruitList.size(); j++){
                    if(seller.fruitList.get(j).name.equals(fName) && seller.fruitList.get(j).variety.equals(vName)){
                        orderedFruit.add(seller.fruitList.get(j));
                        orderedqntt.add(qntt);
                    }
                }
            }
            catch (NoFruitsException ex){
                System.out.println(ex.getMessage());
            }
        }

        this.order = new Order(orderedFruit, orderedqntt, this, seller);

        return this.order;
    }

    public void display(){
        System.out.println();
        System.out.println(this.firstName+" "+this.lastName);
        System.out.println("Ordered fruits -");
        System.out.println("Name\tVariety\tQuantity\tTPrice");
        for(int i=0; i<this.order.fruits.size(); i++){
            System.out.println(this.order.fruits.get(i).name+"\t"+this.order.fruits.get(i).variety+" "+this.order.quantityInKg.get(i)+"\t"+this.order.quantityInKg.get(i)*this.order.fruits.get(i).pricePerKg);
        }
        System.out.println("\nRewards - "+this.Rewards);
    }

}
