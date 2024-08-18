package MiniJavaOrojects02.BiletFiyatHesaplama;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BiletRezervasyon {
    public static void main(String[] args) {
        Bilet bilet = new Bilet();
        List<String> seatsNo = new ArrayList<>();
        for (int i = 1; i < 33; i++) {
            seatsNo.add(String.valueOf(i));
        }
        Bus bus = new Bus("34 IST 79", seatsNo);

        start(bilet,bus);

    }

    public static void start(Bilet bilet, Bus bus) {

        Scanner scanner = new Scanner(System.in);
        int select = 1;

        do {
            System.out.println("Bilet Rezervasyon Sistemine Hosgeldiniz ");

            System.out.print("Gidilecek mesafeyi km olarak giriniz : ");
            bilet.distance = scanner.nextInt();

            System.out.println("Yolculuk tipini seciniz : ");
            System.out.println("1) Tek Yon \n2)Gidis-Donus ");
            bilet.typeNo = scanner.nextInt();

            System.out.println("Lutfen yasinizi giriniz");
            int age = scanner.nextInt();
            if (age < 12) {

            }

            System.out.println("Koltuk no seciniz");
            System.out.println("Tekli koltuk ucreti %20 daha fazla");
            System.out.println(bus.seats);
            bilet.seatNo = scanner.nextInt();
            //kullanicinin sectigi koltugu listeden kaldir
            bus.seats.remove(String.valueOf(bilet.seatNo));
            boolean check = bilet.typeNo == 1 || bilet.typeNo == 2;
            //boolean check2 = (bilet.typeNo == 1 || bilet.typeNo == 2) && bilet.distance > 0 && age > 0 ;
            if (bilet.distance > 0 && age > 0 && check) {
                bilet.price=getTotal(bilet,age);
                bilet.printBilet(bus);
            } else {
                System.out.println("Hatali giris yapildi");
            }
            System.out.println("Yeni islem icin 1, cikis icin 0 giriniz");
            select = scanner.nextInt();


        } while (select != 0);
        System.out.println("iyi gunler dileriz");
    }

    public static double getTotal(Bilet bilet, int age) {
        int dist = bilet.distance;
        int type = bilet.typeNo;
        int seatNo = bilet.seatNo;
        double total = 0;

        switch (type) {
            case 1:
                if (seatNo % 3 == 0) {
                    total = dist * 1.2;
                } else {
                    total = dist * 1;
                }
                System.out.println("Tutar : " + total);
                break;
            case 2:
                if (seatNo % 3 == 0) {
                    total = dist * 2.4;
                } else {
                    total = dist * 2;
                }
                System.out.println("Tutar : " + total);
                total = total * 0.8;
                System.out.println("Cift yon indirimli tutar : " + total);
                break;
        }
        if (age < 13) {
            total = total / 2;
            System.out.println("Yas indirimli tutar : " + total);
        } else if (age > 12 && age < 24) {
            total = total * 0.9;
            System.out.println("Yas indirimli tutar : " + total);
        } else if (age > 65) {
            total = total * 0.7;
            System.out.println("Yas indirimli tutar : " + total);
        }
        return total;

    }


}
