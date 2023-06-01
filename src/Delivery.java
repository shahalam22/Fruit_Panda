public class Delivery implements RoutePlanner {

    public void deliver(Order order){
        String distance = calculateRoute(order.buyer.Address, order.seller.Address);
        this.modifyRWD(order);
        this.modifyQntt(order);
    }

    @Override
    public String calculateRoute(String point1, String point2) {
        String s = point2 + " to " + point1;
        return s;
    }

    private void modifyQntt(Order order){
        for(int i=0; i<order.fruits.size(); i++){
            for(int j=0; j<order.seller.fruitList.size(); j++){
                if(order.fruits.get(i).name.equals(order.seller.fruitList.get(j).name) && order.fruits.get(i).variety.equals(order.seller.fruitList.get(j).variety)){
                    order.seller.fruitList.get(j).totalQuantityKg -= order.quantityInKg.get(i);
                }
            }
        }
    }

    private void modifyRWD(Order order){
        //finding total money spent by buyer
        double totalSpent = 0;
        for(int i=0; i<order.fruits.size(); i++){
            totalSpent = totalSpent + (order.fruits.get(i).pricePerKg*order.quantityInKg.get(i));
        }
        order.buyer.Rewards = (order.buyer.Rewards + totalSpent/100);
    }

}
