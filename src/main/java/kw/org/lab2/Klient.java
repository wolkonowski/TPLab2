package kw.org.lab2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Klasa reprezentująca klienta.
 */
public class Klient {
    /** Mapa zawierająca wszystkie faktury danego klienta.*/
    private final Map<String, Faktura> map = new ConcurrentHashMap<>();
    /** Nazwa danego klienta.*/
    private final String nazwa;

    /**
     * Zwraca klienta o danej nazwie.
     * @param nazwaKlienta nazwa klienta
     */
    public Klient(final String nazwaKlienta) {
        this.nazwa = nazwaKlienta;
    }

    /**
     * Utwórz fakturę o danej nazwie.
     * @param faktura nazwa faktury
     * @return czy faktura została utworzona
     */
    public boolean create(final String faktura) {
        if (map.get(faktura) != null) {
            return false;
        }
        final Faktura fakt = new Faktura(faktura, nazwa);
        map.put(faktura, fakt);
        return true;
    }

    /**
     * Wypisz faktury przyporządkowane danemu klientowi.
     */
    public void list() {
        if (map.isEmpty()) {
            System.out.println("Nie ma jeszcze faktur");
            return;
        }
        for (final Map.Entry<String, Faktura> e: map.entrySet()) {
            System.out.println(e.getKey());
        }
    }

    /**
     * Czy istnieje faktura o danej nazwie?
     * @param faktura nazwa faktury
     * @return Czy istnieje faktura o danej nazwie?
     */
    public boolean find(final String faktura) {
        return !(map.get(faktura) == null);
    }

    /**
     * Wyświetl fakturę o danej nazwie.
     * @param faktura nazwa faktury
     */
    public void show(final String faktura) {
        if (map.get(faktura) == null) {
            return;
        }
        map.get(faktura).print();
    }

    /**
     * Dodaj element do faktury.
     * @param faktura nazwa faktury
     * @param produkt nazwa przedmiotu
     * @param ilosc ilość przedmiotów
     * @param cena cena za sztukę
     */
    public void add(final String faktura,
                    final String produkt,
                    final String ilosc,
                    final String cena) {
        if (map.get(faktura) == null) {
            return;
        }
        try {
            final int iloscInt = Integer.parseInt(ilosc);
            final int cenaInt = Integer.parseInt(cena);
            map.get(faktura).add(produkt, iloscInt, cenaInt);
        } catch (NumberFormatException e) {
            System.out.println("Wpisz poprawną cenę i ilość");
        }


    }
}
