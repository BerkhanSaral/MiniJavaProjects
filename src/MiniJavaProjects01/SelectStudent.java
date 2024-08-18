package MiniJavaProjects01;

import java.util.Scanner;

public class SelectStudent {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Merhaba lutfen formu doldurun");

        System.out.print("Ogrenci sayisi giriniz : ");
        int numbStudent = scanner.nextInt();

        String[] students = new String[numbStudent];
        String[] gender = new String[numbStudent];
        double[] height = new double[numbStudent];
        double[] weight = new double[numbStudent];
        boolean isSuccess = true;

        do {
            isSuccess=true;
            for (int i = 0; i < numbStudent; i++) {
                System.out.print("ogrenci isim : ");
                students[i] = scanner.next();

                System.out.print("cinsiyet : ");
                String gen = scanner.next().toUpperCase().substring(0, 1);
                if (gen.equals("K") || gen.equals("E")) {
                    gender[i] = gen;
                } else {
                    System.out.println("hatali giris");
                    isSuccess = false;
                    break;
                }

                System.out.print("boyu giriniz");
                height[i] = scanner.nextDouble();

                System.out.print("Kiloyu giriniz");
                weight[i] = scanner.nextDouble();
            }
        } while (!isSuccess);
        System.out.println();
        int counter = 0;

        System.out.println("**   kursa secilen ogrenciler  **");
        for (int i = 0; i < numbStudent; i++) {
            if (gender[i].equals("K") && weight[i] >= 50 && weight[i] <= 70 && height[i] > 1.50) {
                System.out.println("isim : " + students[i] + " cinsiyet : " + gender[i] + " boy : " + height[i] + " kilo : " + weight[i]);
                counter++;
            } else if (gender[i].equals("E") && weight[i] >= 70 && weight[i] <= 90 && height[i] > 1.60) {
                System.out.println("isim : " + students[i] + " cinsiyet : " + gender[i] + " boy : " + height[i] + " kilo : " + weight[i]);
                counter++;
            }
        }
        //kursa secilen yoksa
        if (counter == 0) {
            System.out.println("Maalesef kursa gereksinimlerini saglayan ogrenci bulunamadi");
        }

    }
}

