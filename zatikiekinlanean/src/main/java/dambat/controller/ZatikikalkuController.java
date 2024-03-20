package dambat.controller;

import dambat.App;
import dambat.model.*;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.w3c.dom.Text;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Zatikien azterketa egiteko eta erabiltzaileen puntuazioak datu basean erregistratzeko 
 * beharrezkoak diren funtzioak batzen dituen controller-a
 * @author Julen Herrero
 */
public class ZatikikalkuController {

    @FXML
    Label zenbakitzaileBat;
    @FXML
    Label izendatzaileBat;
    @FXML
    Label zenbakitzaileBi;
    @FXML
    Label izendatzaileBi;
    @FXML
    Label eragiketaIkurra;
    @FXML
    Label okerrakPuntuazioa;
    @FXML
    Label asmatutakoakPuntuazioa;
    @FXML
    Label emaitzaOrokorra;
    @FXML
    TextField emaitzaSartu;
    @FXML
    Button hasiBotoia;
    @FXML
    Button ebatziBotoia;
    int puntuZuzenak;
    int puntuOkerrak;
    int ariketaKop;

    Zatikia leheZatikia;
    Zatikia bigarZatikia;

    @FXML
    Button backButton;

    @FXML
    Button prestatuButton;

    @FXML
    Button prButton;

    @FXML
    Label prmezua;

    @FXML
    Label useridLabel;

    @FXML
    TextField prdniLabel;

    @FXML
    TextField prizenaLabel;

    @FXML
    TextField prabizenaLabel;

    @FXML
    TextField pradinaLabel;

    @FXML
    TextField prokupLabel;

    @FXML
    TextField prpuntuazioaLabel;

    

    /**
     * Funtzio honek zatikien azterketa prestatzen du eta azterketa inizializatzen du.
     * Zatikien zenbakitzaileak eta izendatzaileak ausaz aldatzen ditu galderak erantzun ahala, 
     * gainera erabiltzailearen erantzuna gertatzen du geroago zuzentzeko
     */
    @FXML
    public void hasiTesta() {

        useridLabel.setText(App.us.getDni());
        int znb1 = ThreadLocalRandom.current().nextInt(9) + 1;
        int izd1 = ThreadLocalRandom.current().nextInt(9) + 1;
        int znb2 = ThreadLocalRandom.current().nextInt(9) + 1;
        int izd2 = ThreadLocalRandom.current().nextInt(9) + 1;
        int ikurBerria = ThreadLocalRandom.current().nextInt(4) + 1;

        zenbakitzaileBat.setText(String.valueOf(znb1));
        izendatzaileBat.setText(String.valueOf(izd1));
        zenbakitzaileBi.setText(String.valueOf(znb2));
        izendatzaileBi.setText(String.valueOf(izd2));

        switch(ikurBerria) {
            case 1:
                eragiketaIkurra.setText("+");
                break;
            case 2:
                eragiketaIkurra.setText("-");
                break;
            case 3:
                eragiketaIkurra.setText("x");
                break;
            case 4:
                eragiketaIkurra.setText("%");
                break;
        }

        Zatikia lehenZatikia = new Zatikia(Integer.parseInt(zenbakitzaileBat.getText()), Integer.parseInt(izendatzaileBat.getText()));
        Zatikia bigarrenZatikia = new Zatikia(Integer.parseInt(zenbakitzaileBi.getText()), Integer.parseInt(izendatzaileBi.getText()));

        String[] erantzunak = emaitzaSartu.getText().split("/");
        //Zatikia erantzunZatikia = new Zatikia(Integer.parseInt(erantzunak[0]), Integer.parseInt(erantzunak[1]));
        //Zatikia erantzunZatikia = new Zatikia(Integer.parseInt(erantzunak[0]), Integer.parseInt(erantzunak[1]));
        Zatikia erantzunZatikia = new Zatikia(Integer.parseInt(erantzunak[0]), Integer.parseInt(erantzunak[1]));
        emaitzaSartu.setText("");
    }

    /**
     * Funtzio honek erabiltzaileak sartutako erantzuna hartu eta zuzendu egiten du. 
     * Erantzuna zuzena bada puntuazio zuzenari bat gehitzen dio, bestela okerrari bat gehitzen dio.
     * Gainera azterketaren luzeera zehazten du eta bukaeran erantzun orokorra erakusten dio erabiltzaileari.
     */
    @FXML
    public void zuzenduAriketa() {

        Zatikia lehenZatikia = new Zatikia(Integer.parseInt(zenbakitzaileBat.getText()), Integer.parseInt(izendatzaileBat.getText()));
        Zatikia bigarrenZatikia = new Zatikia(Integer.parseInt(zenbakitzaileBi.getText()), Integer.parseInt(izendatzaileBi.getText()));
        String[] erantzunak = emaitzaSartu.getText().split("/");
        Zatikia erantzunZatikia = new Zatikia(Integer.parseInt(erantzunak[0]), Integer.parseInt(erantzunak[1]));

        Zatikia erantzunZuzena = new Zatikia();

        //Zatikia erantzunaBatu = Zatikia.batu(lehenZatikia, bigarrenZatikia);
        //Zatikia erantzunaKendu = Zatikia.kendu(lehenZatikia, bigarrenZatikia);
        //Zatikia erantzunaBiderkatu = Zatikia.batu(lehenZatikia, bigarrenZatikia);
        //Zatikia erantzunaZatitu = Zatikia.batu(lehenZatikia, bigarrenZatikia);

        switch (eragiketaIkurra.getText()) {
            case "+":
                erantzunZuzena = Zatikia.batu(lehenZatikia, bigarrenZatikia);
                break;
            case "-":
                erantzunZuzena = Zatikia.kendu(lehenZatikia, bigarrenZatikia);
                break;
            case "x":
                erantzunZuzena = Zatikia.biderkatu(lehenZatikia, bigarrenZatikia);
                break;
            case "%":
                erantzunZuzena = Zatikia.zatitu(lehenZatikia, bigarrenZatikia);
        }

        if (erantzunZatikia.hamartarBaliokidea() == erantzunZuzena.hamartarBaliokidea()) {
            puntuZuzenak += 1;
            asmatutakoakPuntuazioa.setText(String.valueOf(puntuZuzenak));
            ariketaKop++;

        } else {
            puntuOkerrak += 1;
            okerrakPuntuazioa.setText(String.valueOf(puntuOkerrak));
            ariketaKop++;
        }

        if (ariketaKop == 10) {
            emaitzaOrokorra.setText(String.valueOf(puntuZuzenak) + "/10");
            //emaitzaOrokorra.setText(String.valueOf(puntuZuzenak));
            asmatutakoakPuntuazioa.setText("");
            okerrakPuntuazioa.setText("");
        }
        
        /*if (erantzunZatikia.hamartarBaliokidea() == erantzunaBatu.hamartarBaliokidea()) {
            puntuZuzenak += 1;
            asmatutakoakPuntuazioa.setText(String.valueOf(puntuZuzenak));
        } else if (erantzunZatikia.hamartarBaliokidea() == erantzunaKendu.hamartarBaliokidea()) {
            puntuZuzenak += 1;
            asmatutakoakPuntuazioa.setText(String.valueOf(puntuZuzenak));
        } else if (erantzunZatikia.hamartarBaliokidea() == erantzunaBiderkatu.hamartarBaliokidea()) {
            puntuZuzenak += 1;
            asmatutakoakPuntuazioa.setText(String.valueOf(puntuZuzenak));
        } else if (erantzunZatikia.hamartarBaliokidea() == erantzunaZatitu.hamartarBaliokidea()) {
            puntuZuzenak += 1;
            asmatutakoakPuntuazioa.setText(String.valueOf(puntuZuzenak));
        } else {
            puntuOkerrak += 1;
            okerrakPuntuazioa.setText(String.valueOf(puntuOkerrak));
        }*/
    }

    /**
     * Funtzio honek menu nagusira bideratzen dio erabiltzaileari
     * @throws IOException
     */
    public void menurabuelta() throws IOException {
        App.setRoot("aukeramenua");
    }

    /**
     * Funtzio honek azterketa egiten duen erabiltzailea zein motatakoa den identifikatzen du eta bere datuak zein puntuazioaren informazioa
     * prestatzen du TextField-etan erakutsiz. Hau erabiltzaileari zein datu txertatuko diren erakutsen dio datu horiek errebisatu dezan.
     * @throws IOException
     */
    public void datuakprestatu() throws IOException {
        
        if (App.us instanceof Ikaslea) {
            App.us = (Ikaslea)App.us;
            prdniLabel.setText(App.us.getDni());
            prizenaLabel.setText(App.us.getIzena());
            prabizenaLabel.setText(App.us.getAbizena());
            pradinaLabel.setText(String.valueOf(App.us.getAdina()));
            prokupLabel.setText(App.us.getOkupazioa());
            prpuntuazioaLabel.setText(String.valueOf(emaitzaOrokorra.getText()));
            prmezua.setText("Datuak ondo prestatu dira, errebisatu itzazu mesedez");
        } else {
            App.us = (Erabiltzailea)App.us;
            prdniLabel.setText(App.us.getDni());
            prizenaLabel.setText(App.us.getIzena());
            prabizenaLabel.setText(App.us.getAbizena());
            pradinaLabel.setText(String.valueOf(App.us.getAdina()));
            prokupLabel.setText(App.us.getOkupazioa());
            prpuntuazioaLabel.setText(String.valueOf(emaitzaOrokorra.getText()));
            prmezua.setText("Datuak ondo prestatu dira, errebisatu itzazu mesedez");
        }
    }

    /**
     * Funtzio honek aurretik prestatu diren erabiltzailearen datuak eta puntuazioa datu basean txertatzen ditu
     * @throws IOException
     */
    public void datuaktxertatu() throws IOException {

        /*Atzipena.erregistratuPuntuazioa(App.us.getDni(), App.us.getIzena(), App.us.getAbizena(), 
        String.valueOf(App.us.getAdina()), App.us.getOkupazioa(), String.valueOf(emaitzaOrokorra.getText())); */

        Atzipena.erregistratuPuntuazioa(App.us.getDni(), App.us.getIzena(), App.us.getAbizena(), 
            String.valueOf(App.us.getAdina()), App.us.getOkupazioa(), puntuZuzenak);
        prmezua.setText("Datuak era egokian txertatu dira");
    }
}
