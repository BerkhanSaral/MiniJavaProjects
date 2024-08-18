package MiniJavaProjects01;

import java.util.Random;
import java.util.Scanner;

public class SayisalLoto {
    public static void main(String[] args) {
        startLoto();

    }


    public static void startLoto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("sayisal loto hane sayisi : ");
        int slots = scanner.nextInt();
        System.out.println("Sayilar icin min  deger girin");
        int min = scanner.nextInt();
        System.out.println("Sayilar icin max deger girin");
        int max = scanner.nextInt();

        int[] lotoArr = new int[slots];
        int[] ticketArr = new int[slots];

        //kendi biletim //loto sonucum icin
        int randomNumber1 = 0; //loto bileti
        int randomNumber2 = 0; //kullanici bileti
        Random rnd = new Random();
        boolean isRepeated;

        for (int i = 0; i < slots; i++) {
            do {
                isRepeated = false;
                //0-15} ARASI ALIR
                //randomNumber1 =rnd.nextInt(6)+5; //0,1,2,3,4,5 -->5,6,7,8,9,10
                //random sayi dizide varmi kontrol et
                randomNumber1 = rnd.nextInt(max + 1 - min) + min;
                // 5 10  0 11  5 16  16-5 5 11
                // 0 0 0 0 0
                // 8 4 5 7 2
                for (int j = 0; j < slots; j++) {
                    if (lotoArr[j] == randomNumber1) { //loto dizisindei elemanlar benim yeni urettigim elemanla eslesiyorsa
                        //8-0  1=8 4=0 2=4
                        isRepeated = true;
                        break;
                    }
                }
            } while (isRepeated);
            lotoArr[i] = randomNumber1;

            do {
                isRepeated = false;
                //0-15} ARASI ALIR
                //randomNumber1 =rnd.nextInt(6)+5; //0,1,2,3,4,5 -->5,6,7,8,9,10
                //random sayi dizide varmi kontrol et
                //7 4 6 9 2
                randomNumber2 = rnd.nextInt(max + 1 - min) + min;
                //5
                for (int j = 0; j < slots; j++) {
                    if (ticketArr[j] == randomNumber2) { //loto dizisindei elemanlar benim yeni urettigim elemanla eslesiyorsa
                        isRepeated = true;
                        break;
                    }
                }
            } while (isRepeated);
            ticketArr[i] = randomNumber2;
        }

        System.out.println("Benim biletim : ");
        for (int i = 0; i < ticketArr.length; i++) {
            System.out.print(ticketArr[i] + " ");
        }
        System.out.println();
        System.out.println("Loto sonucu : ");
        for (int i = 0; i < lotoArr.length; i++) {
            System.out.print(lotoArr[i] + " ");
        }

        System.out.println();

        int result = compareArr(lotoArr, ticketArr);
        if (result > 0) {
            System.out.println("Tebrikler " + result + " eslesme var");
        } else {
            System.out.println("Malesef eslesme yok birdahaki sefere");
        }

    }

    // 8 4 5 7 2
    //7 4 6 9 2
    public static int compareArr(int[] arr, int[] brr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < brr.length; j++) {
                if (arr[i] == brr[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
