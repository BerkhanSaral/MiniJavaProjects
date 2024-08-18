package MiniJavaOrojects04.RestaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;

public class DishService {
    List<Dish> dishList = new ArrayList<>();

    public void fillDishList() {
        Dish dish1 = new Dish(100, "Pers Kebabi", 220);
        Dish dish2 = new Dish(201, "Yunan Kahvesi", 50);
        Dish dish3 = new Dish(200, "Kurt Boregi", 70);
        Dish dish4 = new Dish(201, "Orta Asya Ayrani", 30);
        Dish dish5 = new Dish(300, "Caciki", 40);
        Dish dish6 = new Dish(301, "Dolmadaki", 75);
        Dish dish7 = new Dish(500, "Laz Boregi", 80);
        Dish dish8 = new Dish(501, "Halklarin Kardesligi Yemegi", 300);
        this.dishList.add(dish1);
        this.dishList.add(dish2);
        this.dishList.add(dish3);
        this.dishList.add(dish4);
        this.dishList.add(dish5);
        this.dishList.add(dish6);
        this.dishList.add(dish7);
        this.dishList.add(dish8);
    }

    public void showDishMenu() {
        System.out.println("--------Lezzetlerimiz---------");
        System.out.printf("%-3s  %-20s   %-5s \n", "Kod", "Adi", "Fiyat");
        System.out.printf("%-3s  %-20s   %-5s \n", "---", "---", "-----");
        for (Dish dish : this.dishList) {
            System.out.printf("%-3s  %-20s   %-5s Lira\n", dish.getCode(), dish.getName(), dish.getPrice());
        }
    }

    public Dish findDishCode(int code) {
        if (code == 0) {
            System.out.println("Ana menuye yonlendiriliyorsunuz");
        } else {
            for (Dish dish : this.dishList) {
                if (dish.getCode() == code) {
                    return dish;
                }
            }
            System.out.println("Urun bulunamadi");
        }
        return new Dish(0, "", 0);
    }
}
