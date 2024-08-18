package MiniJavaOrojects02.BiletFiyatHesaplama;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    public String numberPlate;//"34 IST 79"
    public List<String> seats = new ArrayList<>(); //1-32

    public Bus(String plaka, List<String> seats) {
        this.numberPlate = plaka;
        this.seats = seats;

    }
}
