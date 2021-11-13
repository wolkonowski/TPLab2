package kw.org.lab2;

import java.util.HashMap;
import java.util.Map;

public class Klient {
    private Map<String,Faktura> list = new HashMap<>();
    private String nazwa;
    public Klient(String nazwa)
    {
        this.nazwa = nazwa;
    }
    public boolean create(String faktura)
    {
        if(list.get(faktura)!=null) return false;
        Faktura f = new Faktura(faktura,nazwa);
        list.put(faktura,f);
        return true;
    }

    public void list() {
        if(list.isEmpty())
        {
            System.out.println("Nie ma jeszcze faktur");
            return;
        }
        for(Map.Entry<String,Faktura> e: list.entrySet())
        {
            System.out.println(e.getKey());
        }
    }

    public boolean find(String faktura) {
        return!(list.get(faktura)==null);
    }

    public void show(String faktura) {
        if(list.get(faktura)==null)return;
        list.get(faktura).print();
    }

    public void add(String faktura, String produkt, String ilosc, String cena) {
        if(list.get(faktura)==null)return;
        try {
            int il = Integer.parseInt(ilosc);
            int c = Integer.parseInt(cena);
            list.get(faktura).add(produkt,il,c);
        }
        catch (Exception e)
        {
            System.out.println("Wpisz poprawną cenę i ilość");
        }


    }
}
