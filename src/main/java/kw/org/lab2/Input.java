package kw.org.lab2;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Klasa odpowiedzialna za interfejs użytkownika.
 * Wszystkie polecenia przesyłamy do klienta, zgodne z Law of Demeter.
 */
public class Input {
    private Controller controller = new Controller();

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
            if (!("".equals(controller.klient))) {
                command += "<" + controller.klient + ">";
            }
            if (!("".equals(controller.faktura))) {
                command += "<" + controller.faktura + ">";
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
                    controller.kLista();
                    break;
                case "nowyKlient":
                    if (args.length < 2) {
                        break;
                    }
                    controller.kNowy(args[1]);
                    break;
                case "klient":
                    if (args.length < 2) {
                        break;
                    }
                    controller.kWybierz(args[1]);
                    break;
                case "faktury":
                    controller.fLista();
                    break;
                case "nowaFaktura":
                    if (args.length < 2) {
                        break;
                    }
                    controller.fNowa(args[1]);
                    break;
                case "faktura":
                    if (args.length < 2) {
                        break;
                    }
                    controller.fWybierz(args[1]);
                    break;
                case "wyswietl":
                    controller.fWyswietl();
                    break;
                case "dodaj":
                    if (args.length < 4) {
                        break;
                    }
                    controller.fDodaj(args);
                    break;
                default:
                    continue;
            }
        }
    }
}
