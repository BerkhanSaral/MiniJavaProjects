package MiniJavaOrojects04.RestaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    List<Order> orderList = new ArrayList<>();

    public void createOrder(DishService dishService) {
        Scanner scanner = new Scanner(System.in);
        int dishCode = -1;
        while (dishCode != 0) {
            System.out.println("Lutfen urun kodunu giriniz : (CIKIS=0)");
            dishCode = scanner.nextInt();
            Dish dish = dishService.findDishCode(dishCode);
            if (dish.getCode() > 0) {
                System.out.println("Adet giriniz");
                int num = scanner.nextInt();
                Order order = new Order(dish, num);
                order.setPrice();
                order.setOrderCode(1000 + this.orderList.size());
                this.orderList.add(order);
            }
            for (Order order : this.orderList) {
                System.out.printf("Siparis kodu : %-5s Lezzet Kodu : %-10s Adi : %-10s   adet : %-3s \n",
                        order.orderCode, order.dish.getCode(), order.dish.getName(), order.numberOfDish);
            }
        }
    }

    public void createOrderCafe(DishSerCafe dishSerCafe) {
        Scanner scanner = new Scanner(System.in);
        int dishCode = -1;
        while (dishCode != 0) {
            System.out.println("Lutfen urun kodunu giriniz : (CIKIS=0)");
            dishCode = scanner.nextInt();
            Dish dish = dishSerCafe.findDishCafeCode(dishCode);
            if (dish.getCode() > 0) {
                System.out.println("Adet giriniz");
                int num = scanner.nextInt();
                Order order = new Order(dish, num);
                order.setPrice();
                order.setOrderCode(1000 + this.orderList.size());
                this.orderList.add(order);
            }
            for (Order order : this.orderList) {
                System.out.printf("Siparis kodu : %-5s Lezzet Kodu : %-10s Adi : %-10s   adet : %-3s \n",
                        order.orderCode, order.dish.getCode(), order.dish.getName(), order.numberOfDish);
            }
        }
    }


    public void deleteOrder(DishService dishService) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = true;
        if (this.orderList.isEmpty()) {
            System.out.println("Herhangi bir siparis yok");
        } else {
            System.out.println("Lutfen iptal edilcek urunu yaziniz : (CIKIS=0)");
            int code = scanner.nextInt();
            for (Order order : orderList) {
                if (order.orderCode == code) {
                    this.orderList.remove(order);
                    System.out.println("Siparisiniz iptal edildi : " + order.dish.toString());
                    isValid = true;
                    break;
                } else {
                    isValid = false;
                }
            }
            if (!isValid) {
                System.out.println("Gecersiz bir siparis kodu girildi");
            }
        }
    }

    public void deleteOrderCafe(DishSerCafe dishSerCafe) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = true;
        if (this.orderList.isEmpty()) {
            System.out.println("Herhangi bir siparis yok");
        } else {
            System.out.println("Lutfen iptal edilcek urunu yaziniz : (CIKIS=0)");
            int code = scanner.nextInt();
            for (Order order : this.orderList) {
                if (order.orderCode == code) {
                    this.orderList.remove(order);
                    System.out.println("Siparisiniz iptal edildi : " + order.dish.toString());
                    isValid = true;
                } else {
                    isValid = false;
                }
            }
            if (!isValid) {
                System.out.println("Gecersiz bir siparis kodu girildi");

            }

        }
    }


    public void printBill() {
        double totalPrice = 0.0;
        System.out.println("Lezzet Fisiniz");
        for (Order order : orderList) {
            System.out.printf("Siparis kodu : %-5s Lezzet Kodu : %-10s Adi : %-10s   adet : %-3s Siparis Tutari : %-5s Lira \n",
                    order.orderCode, order.dish.getCode(), order.dish.getName(), order.numberOfDish, order.orderPrice);
            totalPrice += order.orderPrice;
            System.out.println("Total Price : " + totalPrice);
            System.out.println("Afiyet Olsun");
            this.orderList = new ArrayList<>();
        }
    }

}
