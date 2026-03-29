import java.util.ArrayList;

public class Zamowienie {
    private int numerZamowienia;
    private KlientKawiarni klient;
    private ArrayList<ProduktMenu> produkty;
    private boolean oplacone;
    private static int kolejnyNumer;

    public Zamowienie(KlientKawiarni klient) {
        this.numerZamowienia = kolejnyNumer++;
        this.klient = klient;
        this.produkty = new ArrayList<>();
        this.oplacone = false;
    }

    public void dodajProdukt(ProduktMenu produktMenu) {
        this.produkty.add(produktMenu);
    }

    public double policzWartosc() {
        double wartosc = 0;
        for (ProduktMenu produkt : produkty) {
            wartosc += produkt.getCena();
        }
        return wartosc;
    }

    public int policzLiczbeProduktow() {
        return this.produkty.size();
    }

    public void oznaczJakoOplacone() {
        this.oplacone = true;
    }

    public static int pobierzKolejnyNumer() {
        return kolejnyNumer;
    }

    @Override
    public String toString() {
        return "Zamowienie" + numerZamowienia + "{\n" +
                "klient=" + klient.getImieINazwisko() + ",\n" +
                "produkty=" + produkty + ",\n" +
                "oplacone=" + (oplacone ? "TAK" : "NIE") + ",\n" +
                "lacznaWartosc=" + policzWartosc() + " zł\n" +
                '}';
    }
}
