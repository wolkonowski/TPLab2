package kw.org.lab2;

import java.util.ArrayList;
import java.util.List;

public class Faktura {
    List<ElementFaktury> list = new ArrayList<>();
    String nazwa,klient;
    public Faktura(String nazwa, String klient)
    {
        this.nazwa = nazwa;
        this.klient = klient;
    }
    public void add(String nazwa, int ilosc, int cena)
    {
        ElementFaktury el = new ElementFaktury(nazwa, ilosc, cena);
        list.add(el);
    }
    public void print()
    {
        System.out.println("<<START FAKTURY>>");
        System.out.println("Nazwa:\t"+nazwa);
        System.out.println("Klient:\t"+klient);

        double total = 0;
        for(ElementFaktury e : list) {
            System.out.println(e.getElement());
            total += e.total();
        }
        System.out.println("ŁĄCZNIE:\t"+total+" zł");
        System.out.println("<<KONIEC FAKTURY>>");

    }
}
