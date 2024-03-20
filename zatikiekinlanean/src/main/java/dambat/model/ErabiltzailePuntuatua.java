package dambat.model;

/**
 * ErabiltzailePuntuatua objektu klasea, herentzia jasotzen du Erabiltzaile klasetik
 * @author Julen Herrero
 */
public class ErabiltzailePuntuatua extends Erabiltzailea {
    
    private int puntuazioa;

    /**
     * ErabiltzailePuntuatua objektuaren konstruktorea
     * @param dni erabiltzailearen dni-a
     * @param izena erabiltzailearen izena
     * @param abizena erabiltzailearen abizena
     * @param adina erabiltzailearen adina
     * @param okupazioa erabiltzailearen okupazioa
     * @param puntuazioa erabiltzailearen puntuazioa
     */
    public ErabiltzailePuntuatua(String dni, String izena, String abizena, int adina, String okupazioa, int puntuazioa) {
        
        super(dni, izena, abizena, adina, okupazioa);
        this.puntuazioa = puntuazioa;
    }

    public ErabiltzailePuntuatua(String dni, int puntuazioa) {
        super(dni);
        this.puntuazioa = puntuazioa;
    }

    public int getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(int puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    /**
     * ErabiltzailePuntuatua klasearen toString funtzioa
     * @return ErabiltzailePuntuatua-ren atributuen baloreak
     */
    @Override
    public String toString() {
        return super.toString() + " puntuazioa = " + puntuazioa;
    }
}
