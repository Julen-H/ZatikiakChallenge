package dambat.model;

/**
 * Zatikia objektu klasea
 * @author Julen Herrero
 */
public class Zatikia {
    private int zenbakitzailea;
    private int izendatzailea;

    /**
     * Zatikia objektu klasearen konstruktorea
     * @param zenbakitzailea zatikiaren zenbakitzailea
     * @param izendatzailea zatikiaren izendatzailea
     */
    public Zatikia(int zenbakitzailea, int izendatzailea) {
        this.zenbakitzailea = zenbakitzailea;
        this.izendatzailea = izendatzailea;
    }

    /*
     * pa luego
     * public Zatikia(java.lang.String zatIdatzia) {
     * 
     * }
     */

    /* Konstruktore lehenetsiak, ausazko zatiki bat sortuko du. 
    Bai zenbakitzailea bai izendatzailea 1 eta 10 bitartean dauden 
    zenbakiak izango dira. Sinplifikatuta egongo da. */

    /**
     * Zatikia klasearen konstruktorea, ausaz zatiki bat sortzen du
     */
    public Zatikia() {
        zenbakitzailea = (int) ((Math.random()) * 10) + 1;
        izendatzailea = (int) ((Math.random()) * 10) + 1;
    }

    /**
     * Zatikia klasearen konstruktorea, bi zenbaki / batez banatuta idaztean zatikia sortzen du zenbakitzaileari eta izendatzaileari balore horiek emanez
     * @param zatIdatzia
     */
    public Zatikia(String zatIdatzia) {
        int barra = zatIdatzia.indexOf("/");
        int strLen = zatIdatzia.length();

        String zenbak = zatIdatzia.substring(0, barra);
        String izend = zatIdatzia.substring(barra + 1, strLen);

        zenbakitzailea = Integer.parseInt(zenbak);
        izendatzailea = Integer.parseInt(izend);
    }

    public int getZenbakitzailea() {
        return zenbakitzailea;
    }

    public int getIzendatzailea() {
        return izendatzailea;
    }

    public void setZenbakitzailea(int zenba) {
        zenbakitzailea = zenba;
    }

    public void setIzendatzailea(int izenda) {
        izendatzailea = izenda;
    }

    /**
     * Zatikia objektu klasearen toString funtzioa
     * @return zatikiaren atributu guztien baloreak bueltatzen ditu
     */
    public String toString() {
        return zenbakitzailea + "/" + izendatzailea;
    }

    /**
     * Bi zatikiren arteko biderketa egiten du funtzio honek
     * @param zat1 lehen zatikia
     * @param zat2 bigarren zatikia
     * @return bi zatikien arteko biderketaren emaitza zatiki moduan bueltatzen du
     */
    public static Zatikia biderkatu(Zatikia zat1, Zatikia zat2) {
        Zatikia zat3;
        zat3 = new Zatikia(zat1.zenbakitzailea * zat2.zenbakitzailea, zat1.izendatzailea * zat2.izendatzailea);
        return zat3;
    }

    /**
     * Bi zatikiren arteko zatiketa egiten du funtzio honek
     * @param zat1 lehen zatikia
     * @param zat2 bigarren zatikia
     * @return bi zatikien arteko zatiketaren emaitza zatiki moduan bueltatzen du
     */
    public static Zatikia zatitu(Zatikia zat1, Zatikia zat2) {
        Zatikia zat3;
        zat3 = new Zatikia(zat1.zenbakitzailea * zat2.izendatzailea, zat1.izendatzailea * zat2.zenbakitzailea);
        return zat3;
    }

    /**
     * Bi zatikiren arteko batuketa egiten du funtzio honek
     * @param zat1 lehen zatikia
     * @param zat2 bigarren zatikia
     * @return bi zatikien arteko batuketaren emaitza zatiki moduan bueltatzen du
     */
    public static Zatikia batu(Zatikia zat1, Zatikia zat2) {
        Zatikia zat3 = new Zatikia();
        zat3.zenbakitzailea = (zat1.zenbakitzailea * zat2.izendatzailea + zat1.izendatzailea * zat2.zenbakitzailea);
        zat3.izendatzailea = (zat1.izendatzailea * zat2.izendatzailea);
        return zat3;
    }

    /**
     * Bi zatikiren arteko kenketa egiten du funtzio honek
     * @param zat1 lehen zatikia
     * @param zat2 bigarren zatikia
     * @return bi zatikien arteko kenketaren emaitza zatiki moduan bueltatzen du
     */
    public static Zatikia kendu(Zatikia zat1, Zatikia zat2) {
        Zatikia zat3 = new Zatikia();
        zat3.zenbakitzailea = (zat1.zenbakitzailea * zat2.izendatzailea - zat1.izendatzailea * zat2.zenbakitzailea);
        zat3.izendatzailea = (zat1.izendatzailea * zat2.izendatzailea);
        return zat3;
    }

    /**
     * Bi zatikiren arteko batuketa egiten du, zatiki bat jasotzen du fokoa jarri den zatikiarekin batzeko
     * @param besteZatBat 
     * 
     */
    public void batu(Zatikia besteZatBat) {
        this.zenbakitzailea = this.zenbakitzailea * besteZatBat.izendatzailea + this.izendatzailea * besteZatBat.zenbakitzailea;
        this.izendatzailea = this.izendatzailea * besteZatBat.izendatzailea;
    }

    /**
     * Zatiki baten baliokidea lortzen du funtzio honek
     * @return zatikiaren baliokidea bueltatzen du zatiki moduan
     */
    public double hamartarBaliokidea() {
        double baliokidea;
        baliokidea = (double) this.zenbakitzailea / (double) this.izendatzailea;
        return baliokidea;
    }

    /**
     * Zatiki bat beste baten baliokidea den ala ez zehazten du funtzioak
     * @param besteZatikiBat konparatu nahi den zatikia
     * @return baliokidea bada true bueltatzen du bestela false
     */
    public boolean isBaliokidea(Zatikia besteZatikiBat) {
        
        if (this.hamartarBaliokidea() == besteZatikiBat.hamartarBaliokidea()) {
        return true;
        } else {
            return false;
        }
    }

    /**
     * Zatiki baten zenbakitzailea eta izendatzailea sinplifikatzen ditu funtzio honek
     */
    public void sinplifikatu() {
        Zatikia erantzuna;
            int n = this.mkt(zenbakitzailea, izendatzailea);
            erantzuna = this;
            zenbakitzailea = this.zenbakitzailea/n; //mkt(zenbakitzailea, izendatzailea);
            izendatzailea = this.izendatzailea/n; //mkt(zenbakitzailea, izendatzailea);
            System.out.print(erantzuna);
        }
    
    /**
     * Jasotzen duen zatikia handiago den ala ez zehazten du funtzio honek
     * @param besteZatikiBat
     * @return jasotzen duen zatikia handiagoa bada true bueltatzen du bestela false bueltatzen du
     */
        public boolean isBiggerThan(Zatikia besteZatikiBat) {
        boolean handiagoa = false;

        if ((this.zenbakitzailea / this.izendatzailea) >= (besteZatikiBat.zenbakitzailea
                / besteZatikiBat.izendatzailea)) {
            handiagoa = true;
        }
        return handiagoa;
    }

    /**
     * Multiplo komun txikiena zein den zehazten du funtzio honek
     * @param n1
     * @param n2
     * @return multiplo komun txikienaren balioa bueltatzen du
     */
    public int mkt(int n1, int n2) {
        int multiploKomun = 0;

        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                multiploKomun = i;
            }
        }

        if (multiploKomun == 0) {
            return 1;
        } else {
            return multiploKomun;
        }
    }

    /**
     * Zatitzaile komun handiena bueltatzen du funtzio honek
     * @param n1
     * @param n2
     * @return zatitzaile komun handienaren balio bueltatzen du
     */
    public int zkh(int n1, int n2){
        int zkh = 2;
        int txikiena;

        if(n1<n2){
            txikiena = n1;
        } else {
            txikiena = n2;
        }

        while(zkh<=txikiena){
            if(n1%zkh==0 && n2%zkh==0){
                break;
            }else{
                zkh++;
            }
        }
        return zkh;
    }
}
