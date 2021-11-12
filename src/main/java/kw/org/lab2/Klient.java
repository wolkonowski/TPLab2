package kw.org.lab2;

import java.util.ArrayList;
import java.util.List;

public class Klient {
    private List<Faktura> list = new ArrayList<>();
    private String nazwa;
    public Klient(String nazwa)
    {
        this.nazwa = nazwa;
    }
    public Faktura create()
    {
        Faktura f = new Faktura(this.nazwa);
        list.add(f);
        return f;
    }

}
