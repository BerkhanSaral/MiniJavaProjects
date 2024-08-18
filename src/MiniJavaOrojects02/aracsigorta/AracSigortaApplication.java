package MiniJavaOrojects02.aracsigorta;

import java.util.Scanner;

public class AracSigortaApplication {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        boolean isFail;
        Arac arac = new Arac();
        do {
            isFail = false;

            //menu ve tarife donemi secimi
            System.out.println("--Zorunlu Arac Sigorta Primi Hesaplama");
            System.out.println("Tarife donemi seciniz : ");
            System.out.println("1. Haziran 2024");
            System.out.println("2. Aralik 2024");
            int term = scanner.nextInt();
            //tarife donemi dogru girilmisse isleme devam etsin aksi durumda degilse uyari ver yeni islem sor
            if (term == 1 || term == 2) {
                System.out.println("Arac tipini giriniz");
                System.out.println("otomobil, kamyon, otobus, motor");
                arac.type = scanner.next().toLowerCase();
                arac.prim = arac.countPrim(term);
                int select;
                String termName = term == 1 ? "Haziran 2022" : "Aralik 2022";

                if (arac.prim > 0) {
                    System.out.println("Hesaplama basariyla tamamlandi");
                    System.out.println("Arac tipi : " + arac.type);
                    System.out.println("Tarife Donemi : "+termName);
                    System.out.println("Aracinizin ilgili donem sigorta primi : "+arac.prim);
                    System.out.println("Yeni islem icin 1, cikis icin 0 giriniz");
                    select=scanner.nextInt();
                    if (select == 1) {
                        isFail = true;
                    } else if (select == 0) {
                        isFail = false;
                    }
                } else {
                    System.out.println("Hesaplama basarisiz, tekrar deneyiniz");
                    System.out.println("Yeni islem icin 1, cikis icin 0 giriniz");
                    select = scanner.nextInt();
                    if (select == 1) {
                        isFail = true;
                    } else if (select == 0) {
                        isFail = false;
                    }
                }
            } else {
                System.out.println("Hatali giris");
                isFail = true;
            }
        } while (isFail);
        System.out.println("Iyi gunler dileriz. ");
    }
}
