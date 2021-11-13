package kw.org.lab2;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Klasa reprezentująca klienta.
 */
public class Klient {
    /** Mapa zawierająca wszystkie faktury danego klienta.
     * Reprezentuje bazę danych. */
    private final Map<String, Faktura> map = new ConcurrentHashMap<>();
    /** Nazwa danego klienta.*/
    private final String nazwa;

    /**
     * Dodaj do bazy danych daną fakturę.
     * @param nazwaFaktury nazwa
     * @param faktura faktura
     */
    private void add(final String nazwaFaktury, final Faktura faktura) {
        map.put(nazwaFaktury, faktura);
    }

    /**
     * Odczytaj z bazy fakturę o danej nazwie.
     * @param nazwaFaktury nazwa
     * @return faktura o danej nazwie
     */
    private Faktura get(final String nazwaFaktury) {
        return map.get(nazwaFaktury);
    }

    /**
     * Czy do danego klienta są przyporządkowane faktury?
     * @return Czy do danego klienta są przyporządkowane faktury?
     *
     */
    private boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * Uzyskaj wszystkie faktury danego klienta.
     * @return faktury danego klienta
     */
    private Set<Map.Entry<String, Faktura>> getAll() {
        return map.entrySet();
    }
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
        if (get(faktura) != null) {
            return false;
        }
        final Faktura fakt = new Faktura(faktura, nazwa);
        add(faktura, fakt);
        return true;
    }

    /**
     * Wypisz faktury przyporządkowane danemu klientowi.
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("Nie ma jeszcze faktur");
            return;
        }
        for (final Map.Entry<String, Faktura> e: getAll()) {
            System.out.println(e.getKey());
        }
    }

    /**
     * Czy istnieje faktura o danej nazwie?
     * @param faktura nazwa faktury
     * @return Czy istnieje faktura o danej nazwie?
     */
    public boolean find(final String faktura) {
        return !(get(faktura) == null);
    }

    /**
     * Wyświetl fakturę o danej nazwie.
     * @param faktura nazwa faktury
     */
    public void show(final String faktura) {
        if (get(faktura) == null) {
            return;
        }
        get(faktura).print();
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
        if (get(faktura) == null) {
            return;
        }
        try {
            final int iloscInt = Integer.parseInt(ilosc);
            final int cenaInt = Integer.parseInt(cena);
            get(faktura).add(produkt, iloscInt, cenaInt);
        } catch (NumberFormatException e) {
            System.out.println("Wpisz poprawną cenę i ilość");
        }


    }
}
