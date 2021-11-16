package kw.org.lab2;

/**
 * Interfejs opisujący funkcjonalności bazy danych.
 */
public interface Database {
    /**
     * Dodaj klienta do bazy.
     * @param klient klient
     */
    void addKlient(Klient klient);

    /**
     * Dodaj Fakturę do bazy.
     * @param faktura faktura
     */
    void addFaktura(Faktura faktura);

    /**
     * Uzyskaj klienta o danej nazwie.
     * @param nazwa nazwa klienta
     * @return klient o danej nazwie
     */
    Klient getKlient(String nazwa);

    /**
     * Uzyskaj fakturę o danej nazwie.
     * @param nazwaKlienta nazwa klienta
     * @param nazwaFaktury nazwa faktury
     * @return faktura o danej nazwie
     */
    Faktura getFaktura(String nazwaKlienta, String nazwaFaktury);

    /**
     * Dodaj pozycję do faktury.
     * @param nazwaKlienta nazwa klienta
     * @param nazwaFaktury nazwa faktury
     * @param nazwaProduktu nazwa produktu
     * @param ilosc ilosc produktów
     * @param cena cena za produkt
     */
    void addPozycja(String nazwaKlienta,
                    String nazwaFaktury,
                    String nazwaProduktu,
                    int ilosc,
                    int cena);
}
