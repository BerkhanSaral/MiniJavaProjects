package MiniJavaOrojects02.BiletFiyatHesaplama;

public class Bilet {
    public int distance;
    public int typeNo;
    public double price;
    public int seatNo;


    public void printBilet(Bus bus) {
        System.out.println("Toplam tutar : " + price);
        System.out.println("----------Bilet Detay-----------");
        System.out.println("Otobus Plakaasi : " + bus.numberPlate);
        System.out.println("Mesafe : " + distance);
        System.out.println("Yolculuk Tipi : " + (typeNo == 1 ? "Tek yon" : "Cift yon "));
        System.out.println("Koltuk No : " + seatNo);
        System.out.println("Keyifli yolculuklar dileriz");
    }

}
