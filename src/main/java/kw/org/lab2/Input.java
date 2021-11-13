package kw.org.lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Input {
    Map<String, Klient> list = new HashMap<>();
    String klient="", faktura="";
    void help()
    {
    System.out.println("""
    exit\tZamyka program
    help\tWyświetla dostępne polecenia
    klienci\tWyświetla listę klientów
    nowyKlient <nazwa>\tTworzy klienta
    klient <nazwa>\tWybiera klienta
    faktury\tWyświetla listę faktur
    nowaFaktura <nazwa>\tTworzy fakturę
    faktura <nazwa>\tWybiera fakturę
    wyswietl\tWyświetla obecnie wybraną fakturę
    dodaj <nazwa> <ilosc> <cena[gr]>\tTworzy nowa pozycję na fakturze"""
    );
    }
    void start() {
        Scanner sc = new Scanner(System.in);
        help();
        while (true) {
            String k = "Podaj komendę";
            if(!klient.equals("")) k+="<"+klient+">";
            if(!faktura.equals("")) k+="<"+faktura+">";
            System.out.println(k);
            String s = sc.nextLine();
            String[] args = s.split(" ");
            switch (args[0])
            {
                case "exit":
                    return;
                case "help":
                    help();
                    break;
                case "klienci":
                    K_lista();
                    break;
                case "nowyKlient":
                    if(args.length<2) break;
                    K_nowy(args[1]);
                    break;
                case "klient":
                    if(args.length<2) break;
                    K_wybierz(args[1]);
                    break;
                case "faktury":
                    F_lista();
                    break;
                case "nowaFaktura":
                    if(args.length<2) break;
                    F_nowa(args[1]);
                    break;
                case "faktura":
                    if(args.length<2) break;
                    F_wybierz(args[1]);
                    break;
                case "wyswietl":
                    F_wyswietl();
                    break;
                case "dodaj":
                    if(args.length<4) return;
                    F_dodaj(args);
                    break;
            }
        }
    }

    private void F_dodaj(String[] args) {
        if (faktura.equals(""))
            return;
        list.get(klient).add(faktura,args[1],args[2],args[3]);
    }

    private void F_wyswietl() {
        if (faktura.equals(""))
            return;
        list.get(klient).show(faktura);
    }

    private void F_wybierz(String nazwa) {
        if (klient.equals("")||nazwa.equals(""))
            return;
        if (list.get(klient).find(nazwa))
            faktura=nazwa;
        else
            faktura="";

    }

    private void F_nowa(String nazwa) {
        if (klient.equals("")||nazwa.equals(""))
            return;
        if(list.get(klient).create(nazwa))
        {
            faktura=nazwa;
        }
    }

    private void F_lista() {
        if (klient.equals(""))
            return;
        list.get(klient).list();
    }

    private void K_wybierz(String nazwa) {
        if(list.get(nazwa)==null||nazwa.equals("")) {
            klient = "";
            faktura = "";
        }
        else
        {
            klient = nazwa;
            faktura = "";
        }
    }

    private void K_nowy(String nazwa) {
        if (list.get(nazwa)!=null||nazwa.equals(""))
            return;
        Klient k = new Klient(nazwa);
        list.put(nazwa,k);
        K_wybierz(nazwa);
    }

    private void K_lista() {
        if(list.isEmpty())
        {
            System.out.println("Nie ma jeszcze klientów");
            return;
        }
        for(Map.Entry<String,Klient> e: list.entrySet())
        {
            System.out.println(e.getKey());
        }
    }
}
