package MiniJavaOrojects04.RestaurantBillGenerator;

public class Order {
    public int orderCode;
    public Dish dish;
    public int numberOfDish;
    public double orderPrice;

    public Order(Dish dish, int numberOfDish) {
        this.dish = dish;
        this.numberOfDish = numberOfDish;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }


    public void setPrice() {
        this.orderPrice = this.dish.getPrice() * this.numberOfDish;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderCode=" + orderCode +
                ", dish=" + dish +
                ", numberOfDish=" + numberOfDish +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
