package kw.org.lab2;

public class DBHandler implements Database{

    /**
     * Dodaj klienta do bazy.
     *
     * @param klient klient
     */
    @Override
    public void addKlient(Klient klient) {

    }

    /**
     * Dodaj Fakturę do bazy.
     *
     * @param faktura faktura
     */
    @Override
    public void addFaktura(Faktura faktura) {

    }

    /**
     * Uzyskaj klienta o danej nazwie.
     *
     * @param nazwa nazwa klienta
     * @return klient o danej nazwie
     */
    @Override
    public Klient getKlient(String nazwa) {
        return null;
    }

    /**
     * Uzyskaj fakturę o danej nazwie.
     *
     * @param nazwaKlienta nazwa klienta
     * @param nazwaFaktury nazwa faktury
     * @return faktura o danej nazwie
     */
    @Override
    public Faktura getFaktura(String nazwaKlienta, String nazwaFaktury) {
        return null;
    }

    /**
     * Dodaj pozycję do faktury
     *
     * @param nazwaKlienta  nazwa klienta
     * @param nazwaFaktury  nazwa faktury
     * @param nazwaProduktu nazwa produktu
     * @param ilosc         ilosc produktów
     * @param cena          cena za produkt
     */
    @Override
    public void addPozycja(String nazwaKlienta, String nazwaFaktury, String nazwaProduktu, int ilosc, int cena) {

    }
}
