package kw.org.lab2;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Klasa odpowiedzialna za interfejs użytkownika.
 */
public class Input {
    /** Mapa zawierająca wszystkich klientów. */
    private final Map<String, Klient> map = new ConcurrentHashMap<>();
    /** Nazwa obecnie wybranego klienta. */
    private String klient = "";
    /** Nazwa obecnie wybranej faktury. */
    private String faktura = "";

    /**
     * Wyświetl dostępne komendy.
     */
    private void help() {
        System.out.println("""
        exit\t\t\t\t\t\t\t\tZamyka program
        help\t\t\t\t\t\t\t\tWyświetla dostępne polecenia
        klienci\t\t\t\t\t\t\t\tWyświetla listę klientów
        nowyKlient <nazwa>\t\t\t\t\tTworzy klienta
        klient <nazwa>\t\t\t\t\t\tWybiera klienta
        faktury\t\t\t\t\t\t\t\tWyświetla listę faktur
        nowaFaktura <nazwa>\t\t\t\t\tTworzy fakturę
        faktura <nazwa>\t\t\t\t\t\tWybiera fakturę
        wyswietl\t\t\t\t\t\t\tWyświetla obecnie wybraną fakturę
        dodaj <nazwa> <ilosc> <cena[gr]>\tTworzy nowa pozycję na fakturze"""
        );
    }

    /**
     * Rozpocznij działanie interfejsu.
     */
    public void start() {
        final Scanner scanner = new Scanner(System.in);
        help();
        while (true) {
            String command = "Podaj komendę";
            if (!("".equals(klient))) {
                command += "<" + klient + ">";
            }
            if (!("".equals(faktura))) {
                command += "<" + faktura + ">";
            }
            System.out.println(command);
            final String line = scanner.nextLine();
            final String[] args = line.split(" ");
            switch (args[0]) {
                case "exit":
                    scanner.close();
                    return;
                case "help":
                    help();
                    break;
                case "klienci":
                    kLista();
                    break;
                case "nowyKlient":
                    if (args.length < 2) {
                        break;
                    }
                    kNowy(args[1]);
                    break;
                case "klient":
                    if (args.length < 2) {
                        break;
                    }
                    kWybierz(args[1]);
                    break;
                case "faktury":
                    fLista();
                    break;
                case "nowaFaktura":
                    if (args.length < 2) {
                        break;
                    }
                    fNowa(args[1]);
                    break;
                case "faktura":
                    if (args.length < 2) {
                        break;
                    }
                    fWybierz(args[1]);
                    break;
                case "wyswietl":
                    fWyswietl();
                    break;
                case "dodaj":
                    if (args.length < 4) {
                        break;
                    }
                    fDodaj(args);
                    break;
                default:
                    continue;
            }
        }
    }

    private void fDodaj(final String[] args) {
        if ("".equals(faktura)) {
            return;
        }
        map.get(klient).add(faktura, args[1], args[2], args[3]);
    }

    private void fWyswietl() {
        if ("".equals(faktura)) {
            return;
        }
        map.get(klient).show(faktura);
    }

    private void fWybierz(final String nazwa) {
        if ("".equals(klient) || "".equals(nazwa)) {
            return;
        }
        if (map.get(klient).find(nazwa)) {
            faktura = nazwa;
        } else {
            faktura = "";
        }

    }

    private void fNowa(final String nazwa) {
        if ("".equals(klient) || "".equals(nazwa)) {
            return;
        }
        if (map.get(klient).create(nazwa)) {
            faktura = nazwa;
        }
    }

    private void fLista() {
        if ("".equals(klient)) {
            return;
        }
        map.get(klient).list();
    }

    private void kWybierz(final String nazwa) {
        if (map.get(nazwa) == null || "".equals(nazwa)) {
            klient = "";
        } else {
            klient = nazwa;
        }
        faktura = "";
    }

    private void kNowy(final String nazwa) {
        if (map.get(nazwa) != null || "".equals(nazwa)) {
            return;
        }
        final Klient nowyKlient = new Klient(nazwa);
        map.put(nazwa, nowyKlient);
        kWybierz(nazwa);
    }

    private void kLista() {
        if (map.isEmpty()) {
            System.out.println("Nie ma jeszcze klientów");
            return;
        }
        for (final Map.Entry<String, Klient> e: map.entrySet()) {
            System.out.println(e.getKey());
        }
    }
}
