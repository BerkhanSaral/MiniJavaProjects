package MiniJavaOrojects03.LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<String> usernames = new ArrayList<>();
    List<String> emails = new ArrayList<>();
    List<String> passwords = new ArrayList<>();


    public void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ad-Soyad giriniz : ");
        String name = scanner.nextLine();

        String username;
        boolean existsUsername;
        boolean existsSpaceUsername;
        do {
            System.out.println("Kullanici adi giriniz : ");
            username = scanner.nextLine();
            existsSpaceUsername = username.contains(" ");
            existsUsername = this.usernames.contains(username);//listede username varsa true, yoksa false olucak
            if (existsUsername) {
                System.out.println("Bu username :kullanilmis, farkli bir username deneyiniz");
            }
            if (existsSpaceUsername) {
                System.out.println("Username de bosluk olamaz lutfen yeniden giriniz");
            }
        } while (existsUsername || existsSpaceUsername);


        boolean existsEmail;
        boolean isValid;
        String email;
        do {
            System.out.println("Email giriniz");
            email = scanner.nextLine().trim();
            isValid = validateEmail(email);
            existsEmail = this.emails.contains(email);
            if (existsEmail) {
                System.out.println("Bu email zaten kayitli farkli bir email giriniz");
                isValid = false;
            }
        } while (!isValid);

        boolean existsPassword;
        boolean isValidPassw;
        String password;
        do {
            System.out.println("Password giriniz");
            password = scanner.nextLine();
            isValidPassw = validatePassword(password);
        } while (!isValidPassw);

        User user = new User(name, username, email, password);

        this.usernames.add(user.username);
        this.emails.add(user.email);
        this.passwords.add(user.password);
        System.out.println("Tebrikler isleminiz basariyla gerceklestirildi");
        System.out.println("Kullanici adi veya email ile sisteme giris yapabilirsiniz");
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kullanici adi veya email giriniz");
        String usernameOrEmail = scanner.nextLine();
        boolean isUsername = this.usernames.contains(usernameOrEmail);
        boolean isMail = this.emails.contains(usernameOrEmail);

        if (isUsername || isMail) {
            boolean isWrong = true;
            while (isWrong) {
                System.out.println("Sifreyi Giriniz");
                String password = scanner.nextLine();
                //username/email ile sifre ayni indexte olmali
                int index;
                if (isUsername) {
                    index = this.usernames.indexOf(usernameOrEmail);
                } else {
                    index = this.emails.indexOf(usernameOrEmail);
                }
                if (this.passwords.get(index).equals(password)) {
                    System.out.println("Sisteme giris yaptiniz");
                    isWrong = false;
                } else {
                    System.out.println("Hatali sifre girisi");
                }
            }
        } else {
            System.out.println("Hatali kullanici adi veya email girdiniz");
            System.out.println("Uyeyseniz bilgilerinizi kontrol ediniz");
        }
    }

    public boolean validateEmail(String email) {
        boolean isValid;
        boolean space = email.contains(" ");
        boolean isContainAt = email.contains("@");
        if (space) {
            System.out.println("email bosluk iceremez");
            isValid = false;
        } else if (!isContainAt) {
            System.out.println("Email @ sembolunu icermelidir");
            isValid = false;
        } else {
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            int notValid = firstPart.replaceAll("[a-zA-Z0-9-._]", "").length();
            boolean checkStart = notValid == 0;

            boolean checkEnd = secondPart.equals("gmail.com") ||
                    secondPart.equals("hotmail.com") ||
                    secondPart.equals("yahoo.com");

            if (!checkStart) {
                System.out.println("email kullanici adi buyuk kucuk harf rakam -_, disinda karakter icermez");
            } else if (!checkEnd) {
                System.out.println("email gmail.com, hotmail.com,yahoo.com  ile bitmelidir");
            }
            isValid = checkEnd && checkStart;
        }
        if (!isValid) {
            System.out.println("Gecersiz email tekrar deneyin");
        }
        return isValid;
    }

    public boolean validatePassword(String password) {
        boolean isValid;

        String upperLetter = password.replaceAll("[^A-Z]", "");
        String lowerLetter = password.replaceAll("[^a-z]", "");
        String digit = password.replaceAll("[\\D]", "");
        String symbol = password.replaceAll("[\\P{Punct}]", "");

        boolean space = password.contains(" ");
        boolean lengthGt6 = password.length() >= 6;
        boolean existsUpper = upperLetter.length() > 0;
        boolean existsLower = lowerLetter.length() > 0;
        boolean existsDigit = digit.length() > 0;
        boolean existsSymbol = symbol.length() > 0;

        if (space) {
            System.out.println("Sifre bosluk icereme");
        } else if (!lengthGt6) {
            System.out.println("Sifre en az 6 karakterden uzun olmali");
        } else if (!existsUpper) {
            System.out.println("Sifre buyuk harf icermeli");
        } else if (!existsLower) {
            System.out.println("Sifre kucuk harf icermeli");
        } else if (!existsDigit) {
            System.out.println("Sifre sayi icermeli");
        } else if (!existsSymbol) {
            System.out.println("Sifre sembol icermeli");
        }

        isValid = !space && lengthGt6 && existsLower && existsUpper && existsDigit && existsSymbol;
        if (!isValid) {
            System.out.println("Gecersiz sifre, Tekrar deneyiniz");
        }

        return isValid;

    }
}
