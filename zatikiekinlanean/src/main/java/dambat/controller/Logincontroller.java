package dambat.controller;

import dambat.App;
import dambat.model.*;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Erabiltzaileak programara logeatzeko beharrezkoak diren funtzioak batzen dituen controller-a
 * @author Julen Herrero
 */
public class Logincontroller {
    
    @FXML
    TextField dniField;

    @FXML
    TextField pwField;

    @FXML
    Button logButton;

    @FXML
    Button cleanButton; 

    @FXML
    Button sortuButton;

    /**
     * Funtzio honek logeatzen ari den erabiltzaileari deitzen dio eta ikasle edo erabiltzaile motatakoa den identifikatzen du,
     * gainera bere kontuko pasahitza eta programan sartu den pasahitza konparatzen ditu. Berdinak badira logeatu egiten du menu nagusira eramanez
     * @throws IOException
     */
    public void logeatu() throws IOException {

        App.us = Atzipena.erabiltzaileaLortu(dniField.getText());

        if (App.us instanceof Ikaslea) {
            App.us = (Ikaslea)App.us;

            if (((Ikaslea) App.us).getPasahitza().equals(pwField.getText()))
                App.setRoot("aukeramenua");

        } else if (App.us instanceof Erabiltzailea) {
            App.us = (Erabiltzailea)App.us;

            if (((Erabiltzailea) App.us).getPasahitza().equals(pwField.getText())) {
                App.setRoot("aukeramenua");
            }    
        }
    }

    /**
     * Funtzio honek logineko TextField-ak garbitzen ditu
     * @throws IOException
     */
    public void garbitu() throws IOException {
        dniField.setText("");
        pwField.setText("");
    }

    /**
     * Funtzio honek erregistratzeko aukera ematen dio erabiltzaileari eszenaz aldatuz
     * @throws IOException
     */
    public void erregistratu() throws IOException {
        App.setRoot("erregistratu");
    }
}
