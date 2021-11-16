package kw.org.lab2;

import static org.junit.Assert.*;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

public class FakturaTest {
    private static final String nazwa = "F1";
    private static final String klient = "K1";
    private static final String produkt = "Kurtka";
    private static final int cena = 30000;
    private static final int ilosc = 10;
    private static final String expected = "Kurtka\t10szt. * 300.0zł\tRAZEM 3000.0zł";
    @Test
    public void testFaktura() {
        Faktura faktura = new Faktura(nazwa, klient);
        faktura.add(produkt, ilosc, cena);

        Field privateField = null;
        try {
            privateField = Faktura.class.getDeclaredField("list");
            privateField.setAccessible(true);
            List<ElementFaktury> list = (List<ElementFaktury>) privateField.get(faktura);
            assertEquals(expected, list.get(0).getElement());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}