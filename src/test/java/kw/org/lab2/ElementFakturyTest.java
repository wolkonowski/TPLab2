package kw.org.lab2;

import static org.junit.Assert.*;
import org.junit.Test;

public class ElementFakturyTest {
    private static final String nazwa = "Kurtka";
    private static final int cena = 30000;
    private static final int ilosc = 10;
    private static final String expected = "Kurtka\t10szt. * 300.0zł\tRAZEM 3000.0zł";
    @Test
    public void testElement() {
        ElementFaktury element = new ElementFaktury(nazwa, ilosc, cena);
        assertEquals(expected, element.getElement());
    }
}