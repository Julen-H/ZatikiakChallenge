package dambat.controller;

import java.io.IOException;

import dambat.App;
import dambat.model.Atzipena;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Erregistroaren controller-a. Kontu berri bat sortzeko beharrezkoak diren funtzioak batzen ditu
 * @author Julen Herrero
 */
public class Erregistratucontroller {
    
    @FXML
    Button backButton;
    
    @FXML
    TextField dniField;

    @FXML
    TextField abzField;

    @FXML
    TextField iznField;

    @FXML
    TextField adnField;

    @FXML
    TextField emField;

    @FXML
    TextField tlfField;

    @FXML
    TextField pwdField;

    @FXML
    TextField okupField;

    @FXML
    TextField ikField;

    @FXML
    TextField zentroField;

    @FXML
    TextField motaField;

    @FXML
    Button registerButton;

    @FXML
    Button cleanButton;

    @FXML
    Label egokiMezua;

    
    /** 
     * Funtzio honek menura bueltatzen dio erabiltzaileari
     * @throws IOException
     */
    public void menuraBuelta() throws IOException {
        App.setRoot("login");
    }

    /**
     * Funtzio honek TextField guztien testuak ezabatzen du
     * @throws IOException
     */
    public void datuakGarbitu() throws IOException {
        
        dniField.setText("");
        iznField.setText("");
        abzField.setText("");
        adnField.setText("");
        emField.setText("");
        tlfField.setText("");
        pwdField.setText("");
        okupField.setText("");
        ikField.setText("");
        zentroField.setText("");
        motaField.setText("");
        egokiMezua.setText("");
        
    }

    /**
     * Funtzio honek erabiltzaileak sartutako datuak datu basean txertatzen ditu kontu berri bat sortuz
     * @throws IOException
     */
    public void kontuaSortu() throws IOException {

        Atzipena.erregistratuKontua(dniField.getText(), iznField.getText(), abzField.getText(), Integer.parseInt(adnField.getText()), 
        emField.getText(), tlfField.getText(), pwdField.getText(), okupField.getText(), ikField.getText(), 
        zentroField.getText(), motaField.getText());

        egokiMezua.setText("ZURE KONTUA ERA EGOKIAN SORTU DA");
    }


}
