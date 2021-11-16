package kw.org.lab2;

import org.junit.runner.RunWith;
//import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
/**
 * Implementacja bazy danych.
 * Możemy testować jej zachowania używając
 */
public class DBHandler implements Database {

    /**
     * Dodaj klienta do bazy.
     *
     * @param klient klient
     */
    @Override
    public void addKlient(final Klient klient) {

    }

    /**
     * Dodaj Fakturę do bazy.
     *
     * @param faktura faktura
     */
    @Override
    public void addFaktura(final Faktura faktura) {

    }

    /**
     * Uzyskaj klienta o danej nazwie.
     *
     * @param nazwa nazwa klienta
     * @return klient o danej nazwie
     */
    @Override
    public Klient getKlient(final String nazwa) {
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
    public Faktura getFaktura(final String nazwaKlienta,
                              final String nazwaFaktury) {
        return null;
    }

    /**
     * Dodaj pozycję do faktury.
     *
     * @param nazwaKlienta  nazwa klienta
     * @param nazwaFaktury  nazwa faktury
     * @param nazwaProduktu nazwa produktu
     * @param ilosc         ilosc produktów
     * @param cena          cena za produkt
     */
    @Override
    public void addPozycja(final String nazwaKlienta,
                           final String nazwaFaktury,
                           final String nazwaProduktu,
                           final int ilosc,
                           final int cena) {

    }
}
