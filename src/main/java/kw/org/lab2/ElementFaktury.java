package kw.org.lab2;

/**
 * Klasa reprezentująca pozycję na fakturze.
 * Element sam oblicza swój łączny koszt, zgodne z Expert.
 */
public class ElementFaktury {
    /** Nazwa produktu. */
    private final String nazwa;
    /** Ilość produktów. */
    private final int ilosc;
    /** Cena za sztukę produktu. */
    private final int cena;

    /** Tworzy element faktury.
     *
     * @param produkt nazwa produktu
     * @param iloscProduktow ilosc produktów
     * @param cenaZaSztuke cena w gr za sztukę
     */
    public ElementFaktury(final String produkt,
                          final int iloscProduktow,
                          final int cenaZaSztuke) {
        this.nazwa = produkt;
        this.ilosc = iloscProduktow;
        this.cena = cenaZaSztuke;
    }

    /**
     * Podlicz wartość pozycji.
     * @return wartość pozycji
     */
    public double total() {
        return (double) (ilosc * cena) / 100;
    }

    /**
     * Wyświelt linię reprezentującą daną pozycję.
     * @return zwraca reprezentację danej pozycji
     */
    public String getElement() {
        return nazwa + "\t"
                + ilosc + "szt. * " + (double) cena / 100
                + "zł\tRAZEM " + total() + "zł";
    }
}
