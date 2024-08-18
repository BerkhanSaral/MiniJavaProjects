package MiniJavaOrojects04.RestaurantBillGenerator;

import java.util.Scanner;

public class RestaurantBillGenerator {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        OrderService orderService = new OrderService();
        DishService dishService = new DishService();
        DishSerCafe dishSerCafe = new DishSerCafe();
        dishService.fillDishList();
        dishSerCafe.fillDishListCafe();
        getSelectionsMenu(dishService, dishSerCafe, orderService);
    }

    public static void getSelectionsMenu(DishService dishService, DishSerCafe dishSerCafe, OrderService orderService) {
        Scanner scanner = new Scanner(System.in);
        int select = -1;

        System.out.println("1-)Restaurant / 2-)Cafe");
        select = scanner.nextInt();

        if (select == 1) {
            while (select != 0) {
                System.out.println("------------------------------------------------------");
                System.out.println("****Lezzet Restaurant****");
                System.out.println("1-)Menu");
                System.out.println("2-)Siparis Gir");
                System.out.println("3-)Siparis Iptal");
                System.out.println("4-)Hesap Olusturma");
                System.out.println("0-)Cikis");
                System.out.println("Seciminiz");
                select = scanner.nextInt();
                System.out.println("--------------------------------------------------------");
                switch (select) {
                    case 1:
                        dishService.showDishMenu();
                        break;
                    case 2:
                        orderService.createOrder(dishService);
                        break;
                    case 3:
                        orderService.deleteOrder(dishService);
                        break;
                    case 4:
                        orderService.printBill();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Hatali giris yapildi");
                        break;
                }
            }
        }
        if (select == 2) {
            while (select != 0) {
                System.out.println("------------------------------------------------------");
                System.out.println("****Cafe Siparis Uygulamasi****");
                System.out.println("1-)Menu");
                System.out.println("2-)Siparis Gir");
                System.out.println("3-)Siparis Iptal");
                System.out.println("4-)Hesap Olusturma");
                System.out.println("0-)Cikis");
                System.out.println("Seciminiz");
                select = scanner.nextInt();
                System.out.println("--------------------------------------------------------");
                switch (select) {
                    case 1:
                        dishSerCafe.showDishCafeMenu();
                        break;
                    case 2:
                        orderService.createOrderCafe(dishSerCafe);
                        break;
                    case 3:
                        orderService.deleteOrderCafe(dishSerCafe);
                        break;
                    case 4:
                        orderService.printBill();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Hatali giris yapildi");
                        break;
                }
            }
        }

        System.out.println("iyi gunler dileriz");
    }
}
