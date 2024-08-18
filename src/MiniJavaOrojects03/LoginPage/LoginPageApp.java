package MiniJavaOrojects03.LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginPageApp {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        start();
    }

    public static void start() {
        UserService service = new UserService();
        Scanner scanner = new Scanner(System.in);
        int select = 1;
        do {
            showMenu();
            select = scanner.nextInt();
            switch (select) {
                case 1:
                    service.register();
                    System.out.println(service.usernames);
                    System.out.println(service.emails);
                    System.out.println(service.passwords);
                    break;
                case 2:
                    service.login();
                    System.out.println(service.usernames);
                    System.out.println(service.emails);
                    System.out.println(service.passwords);
                    break;
                case 0:
                    System.out.println("iyi gunler dileriz");
                    break;
                default:
                    System.out.println("Hatali giris yaptiniz lutfen tekrar deneyiniz");
                    break;
            }
        } while (select != 0);
    }

    private static void showMenu() {
        System.out.println("====TECHPROEDUCATION====");
        System.out.println("1-) Uye Ol");
        System.out.println("2-)Giris Yap");
        System.out.println("0-) Cikis Yap");
        System.out.println("Seciminiz : ");
    }
}
