package dambat.model;

/**
 * Erabiltzaile objektu klasearen klasea
 * @author Julen Herrero
 */
public class Erabiltzailea {
    
    private String dni;
    private String izena;
    private String abizena;
    private int adina;
    private String emaila;
    private String telefonoa;
    private String pasahitza;
    private String okupazioa;

    /**
     * Erabiltzaile klasearen konstruktorea
     * @param dni erabiltzailearen dni-a
     * @param izena erabiltzailearen izena
     * @param abizena erabiltzailearen abizena
     * @param adina erabiltzailearen adina
     * @param emaila erabiltzailearen emaila
     * @param telefonoa erabiltzailearen telefonoa
     * @param pasahitza erabiltzailearen pasahitza
     * @param okupazioa erabiltzailearen okupazioa
     */
    public Erabiltzailea(String dni, String izena, String abizena, int adina, String emaila, String telefonoa, String pasahitza, String okupazioa) {

        this.dni = dni;
        this.izena = izena;
        this.abizena = abizena;
        this.adina = adina;
        this.emaila = emaila;
        this.telefonoa = telefonoa;
        this.pasahitza = pasahitza;
        this.okupazioa = okupazioa;
    }

    /**
     * Erabiltzaile klasearen konstruktorea. Puntuazioa erabiltzeko erabilia
     * @param dni erabiltzailearen dni-a
     * @param izena erabiltzailearen izena
     * @param abizena erabiltzailearen abizena
     * @param adina erabiltzailearen adina
     * @param okupazioa erabiltzailearen okupazioa
     */
    public Erabiltzailea(String dni, String izena, String abizena, int adina, String okupazioa) {
        this.dni = dni;
        this.izena = izena;
        this.abizena = abizena;
        this.adina = adina;
        this.okupazioa = okupazioa;
    }

    public Erabiltzailea(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getAbizena() {
        return abizena;
    }

    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    public int getAdina() {
        return adina;
    }

    public void setAdina(int adina) {
        this.adina = adina;
    }

    public String getEmaila() {
        return emaila;
    }

    public void setEmaila(String emaila) {
        this.emaila = emaila;
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(String telefonoa) {
        this.telefonoa = telefonoa;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    public String getOkupazioa() {
        return okupazioa;
    }

    public void setOkupazioa(String okupazioa) {
        this.okupazioa = okupazioa;
    }

    /**
     * Erabiltzaile objektuaren toString funtzioa
     * @return erabiltzaile klasearen atributuen datuak bueltatzen ditu
     */
    @Override
    public String toString() {
        return getClass() + "[dni = " + dni + ", izena = " + izena + ", abizena = " + abizena + ", adina = " + adina
                + ", emaila = " + emaila + ", telefonoa = " + telefonoa + ", pasahitza = " + pasahitza + ", okupazioa = " + okupazioa + "]";
    }

    

    
}
