package dambat.model;

/**
 * Ikaslea objektu klasea
 * @author Julen Herrero
 */
public class Ikaslea extends Erabiltzailea {

    private String ikasketak;
    private String zentroa;
    private String mota;

    /**
     * Ikaslea objektu klasearen konstruktorea
     * @param dni ikaslearen dni-a
     * @param izena ikaslearen izena
     * @param abizena ikaslearen abizena
     * @param adina ikaslearen adina
     * @param emaila ikaslearen emaila
     * @param telefonoa ikaslearen telefonoa
     * @param pasahitza ikaslearen pasahitza
     * @param okupazioa ikaslearen okupazioa
     * @param ikasketak ikaslearen ikasketak
     * @param zentroa ikaslearen zentroa
     * @param mota ikasle mota
     */
    public Ikaslea(String dni, String izena, String abizena, int adina, String emaila, String telefonoa, String pasahitza, String okupazioa, 
    String ikasketak, String zentroa, String mota) {
        
        super(dni, izena, abizena, adina, emaila, telefonoa, pasahitza, okupazioa);
        
        this.ikasketak = ikasketak;
        this.zentroa = zentroa;
        this.mota = mota;
    }

    public String getIkasketak() {
        return ikasketak;
    }

    public void setIkasketak(String ikasketak) {
        this.ikasketak = ikasketak;
    }

    public String getZentroa() {
        return zentroa;
    }

    public void setZentroa(String zentroa) {
        this.zentroa = zentroa;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    /**
     * Ikasle objektu klasearen toString funtzioa
     * @return Ikasle objektuaren atributu guztien baloreak bueltatzen du
     */
    @Override
    public String toString() {
        return super.toString() + " ikasketak = " + ikasketak + " zentroa = " + zentroa + " mota = " + mota;
    }
}