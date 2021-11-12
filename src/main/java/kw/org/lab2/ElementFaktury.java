package kw.org.lab2;

public class ElementFaktury {

    private String nazwa;
    private int ilosc;
    private int cena;
    public ElementFaktury(String nazwa, int ilosc, int cena)
    {
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.cena = cena;
    }
    public double total()
    {
        return (double) (ilosc*cena)/100;
    }
    public String getElement()
    {
        return nazwa+"\t"+ilosc+"szt. * "+(double)cena/100+"zl\tRAZEM "+total()+"zł";
    }
}
