package MiniJavaOrojects02.aracsigorta;

import java.util.Scanner;

public class Arac {
    public String type;

    public int prim;




    public int countPrim(int term) {
        if (term == 1) {
            switch (type) {
                case "otomobil":
                    prim = 2000;
                    break;
                case "kamyon":
                    prim = 3000;
                    break;
                case "otobus":
                    countBusPrim(term);
                    break;
                case "motor":
                    prim = 1500;
                    break;
                default:
                    System.out.println("Hatali giris");
                    prim = 0;
                    break;
            }
        } else if (term == 2) {
            switch (type) {
                case "otomobil":
                    prim = 2500;
                    break;
                case "kamyon":
                    prim = 3500;
                    break;
                case "otobus":
                    countBusPrim(term);
                    break;
                case "motor":
                    prim = 1750;
                    break;
                default:
                    System.out.println("Hatali giris");
                    break;
            }
        } else {
            System.out.println("Hatali giris");
            prim=0;
        }
        return prim;
    }

    public int countBusPrim(int term) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lutfen otobus tipini giriniz : ");
        System.out.println("1-(18-30 koltul), 2-31 ve uzeri koltuk ");
        int busType = scanner.nextInt();
        switch (busType) {
            case 1:
                if (term == 1) {
                    prim = 4000;
                } else if (term == 2) {
                    prim = 4500;
                }
                break;
            case 2:
                if (term == 1) {
                    prim = 5000;
                } else if (term == 2) {
                    prim = 5500;
                }
                break;
            default:
                System.out.println("Hatai giris yaptiniz");
                break;
        }
        return prim;
    }


}
