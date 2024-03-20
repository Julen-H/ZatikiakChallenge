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
 * Menu nagusiaren controller-a
 * @author Julen Herrero
 */
public class Aukeramenuacontroller {
    
    @FXML
    Button azterketaButton;

    @FXML
    Button taulaButton;

    @FXML
    Button grafikoaButton;

    
    /** 
     * Funtzio honek azterketara bideratzen dio erabiltzaileari eszenaz aldatuz
     * @throws IOException
     * 
     */
    public void azterketaEgin() throws IOException {
        App.setRoot("zatikikalku");
        System.out.println(App.us);
    }

    /**
     * Funtzio honek puntuazio taulara bideratzen dio erabiltzaileari
     * @throws IOException
     * 
     */
    public void taulaikusi() throws IOException {
        App.setRoot("puntuaziotaula");
    }

    /**
     * Funtzio honek grafikora bideratzen dio erabiltzaileari
     * @throws IOException
     * 
     */
    public void grafikoaikusi() throws IOException {
        App.setRoot("puntugrafikoa");
    } 

    
}
