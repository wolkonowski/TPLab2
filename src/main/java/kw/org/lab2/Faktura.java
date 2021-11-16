package kw.org.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca daną fakturę.
 */
public class Faktura {
    /** Lista wszystkich pozycji na fakturze. */
    private final List<ElementFaktury> list = new ArrayList<>();
    /** Nazwa faktury. */
    private final String nazwa;
    /** Nazwa klienta. */
    private final String klient;
    /** Baza danych. */
    private final DBHandler db = new DBHandler();
     /**
     * Tworzy fakturę o danej nazwie.
     * @param nazwaFaktury nazwa faktury
     * @param nazwaKlienta nazwa klienta
     */
    public Faktura(final String nazwaFaktury, final String nazwaKlienta) {
        this.nazwa = nazwaFaktury;
        this.klient = nazwaKlienta;
    }

    /**
     * Dodaj produkt do faktury.
     * @param produkt nazwa produktu
     * @param ilosc ilość
     * @param cena cena
     */
    public void add(final String produkt, final int ilosc, final int cena) {
        final ElementFaktury elem = new ElementFaktury(produkt, ilosc, cena);
        list.add(elem);
        db.addPozycja(klient, nazwa, produkt, ilosc, cena);
    }

    /**
     * Wyświetl reprezentację danej faktury.
     */
    public void print() {
        System.out.println("<<START FAKTURY>>");
        System.out.println("Nazwa:\t" + nazwa);
        System.out.println("Klient:\t" + klient);

        double total = 0;
        for (final ElementFaktury e : list) {
            System.out.println(e.getElement());
            total += e.total();
        }
        System.out.println("ŁĄCZNIE:\t" + total + " zł");
        System.out.println("<<KONIEC FAKTURY>>");

    }
}
