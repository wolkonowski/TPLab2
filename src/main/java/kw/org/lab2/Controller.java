package kw.org.lab2;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class Controller {
    /** Mapa zawierająca wszystkich klientów. */
    public final Map<String, Klient> map = new ConcurrentHashMap<>();
    /** Nazwa obecnie wybranego klienta. */
    public String klient = "";
    /** Nazwa obecnie wybranej faktury. */
    public String faktura = "";
    /** Baza danych. */
    public final DBHandler db = new DBHandler();
    /**
     * Dodaj do bazy danych danego klienta.
     * @param nazwa nazwa
     * @param klientName faktura
     */
    private void add(final String nazwa, final Klient klientName) {
        map.put(nazwa, klientName);
        db.addKlient(klientName);
    }

    /**
     * Odczytaj z bazy klienta o danej nazwie.
     * @param nazwa nazwa
     * @return klient o danej nazwie
     */
    private Klient get(final String nazwa) {
        return map.get(nazwa);
    }

    /**
     * Czy w bazie są klienci?
     * @return Czy w bazie są klienci?
     *
     */
    private boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * Uzyskaj wszystkich klientów.
     * @return wszyscy klienci
     */
    private Set<Map.Entry<String, Klient>> getAll() {
        return map.entrySet();
    }
    public void fDodaj(final String[] args) {
        if ("".equals(faktura)) {
            return;
        }
        get(klient).add(faktura, args[1], args[2], args[3]);
    }

    public void fWyswietl() {
        if ("".equals(faktura)) {
            return;
        }
        get(klient).show(faktura);
    }

    public void fWybierz(final String nazwa) {
        if ("".equals(klient) || "".equals(nazwa)) {
            return;
        }
        if (get(klient).find(nazwa)) {
            faktura = nazwa;
        } else {
            faktura = "";
        }

    }

    public void fNowa(final String nazwa) {
        if ("".equals(klient) || "".equals(nazwa)) {
            return;
        }
        if (get(klient).create(nazwa)) {
            faktura = nazwa;
        }
    }

    public void fLista() {
        if ("".equals(klient)) {
            return;
        }
        get(klient).list();
    }

    public void kWybierz(final String nazwa) {
        if (get(nazwa) == null || "".equals(nazwa)) {
            klient = "";
        } else {
            klient = nazwa;
        }
        faktura = "";
    }

    public void kNowy(final String nazwa) {
        if (get(nazwa) != null || "".equals(nazwa)) {
            return;
        }
        final Klient nowyKlient = new Klient(nazwa);
        add(nazwa, nowyKlient);
        kWybierz(nazwa);
    }

    public void kLista() {
        if (isEmpty()) {
            System.out.println("Nie ma jeszcze klientów");
            return;
        }
        for (final Map.Entry<String, Klient> e: getAll()) {
            System.out.println(e.getKey());
        }
    }
}
