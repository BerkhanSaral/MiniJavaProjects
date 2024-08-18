package MiniJavaOrojects04.RestaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;

public class DishSerCafe {
    List<Dish> dishListCafe = new ArrayList<>();

    public void fillDishListCafe() {
        Dish dish1 = new Dish(400, "Dondurma", 25.5);
        Dish dish2 = new Dish(401, "Portakal Suyu", 25.5);
        Dish dish3 = new Dish(402, "Tulumba", 35.5);
        Dish dish4 = new Dish(403, "Tiramisu", 35.0);
        Dish dish5 = new Dish(404, "Baklava", 40.0);
        Dish dish6 = new Dish(405, "Latte", 60);
        this.dishListCafe.add(dish1);
        this.dishListCafe.add(dish2);
        this.dishListCafe.add(dish3);
        this.dishListCafe.add(dish4);
        this.dishListCafe.add(dish5);
        this.dishListCafe.add(dish6);
    }

    public void showDishCafeMenu() {
        System.out.println("--------Lezzetlerimiz---------");
        System.out.printf("%-3s  %-20s   %-5s \n", "Kod", "Adi", "Fiyat");
        System.out.printf("%-3s  %-20s   %-5s \n", "---", "---", "-----");
        for (Dish dishCafe : this.dishListCafe) {
            System.out.printf("%-3s  %-20s   %-5s Lira\n", dishCafe.getCode(), dishCafe.getName(), dishCafe.getPrice());
        }
    }

    public Dish findDishCafeCode(int code) {
        if (code == 0) {
            System.out.println("Ana menuye yonlendiriliyorsunuz");
        } else {
            for (Dish dish : this.dishListCafe) {
                if (dish.getCode() == code) {
                    return dish;
                }
            }
            System.out.println("Urun bulunamadi");
        }
        return new Dish(0, "", 0);
    }

}
