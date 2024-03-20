package dambat.controller;

import java.io.IOException;
import dambat.model.*;

import dambat.App;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Puntuazio altuenen TableView-a betetzeko beharrezkoak diren funtzioak batzen dituen controller-a
 * @author Julen Herrero
 */
public class Puntuaziotaulacontroller {
    
    @FXML
    TableView<ErabiltzailePuntuatua> puntuTaula;

    @FXML
    TableColumn<ErabiltzailePuntuatua, String> idColumn;

    @FXML
    TableColumn<ErabiltzailePuntuatua, String> izenaColumn;

    @FXML
    TableColumn<ErabiltzailePuntuatua, String> abizenaColumn;

    @FXML
    TableColumn<ErabiltzailePuntuatua, Integer> adinaColumn;

    @FXML
    TableColumn<ErabiltzailePuntuatua, String> okupazioaColumn;

    @FXML
    TableColumn<ErabiltzailePuntuatua, String> puntColumn;

    @FXML
    Button backButton;

    @FXML
    Button prestButton;

    @FXML
    Label dniGoikoa;

    
    /** 
     * Funtzio honek menu nagusira bueltatzeko aukera ematen dio erabiltzaileari
     * @throws IOException
     */
    public void menurabuelta() throws IOException {
        App.setRoot("aukeramenua");
    }

    /**
     * Funtzio honek puntuazio altuenen taula betetzen du, horretarako, ErabiltzailePuntuatua motatako ObservableList bat jasotzen du beste funtzio bati deituz
     * @throws IOException
     */
    public void taulaBete() throws IOException {

        dniGoikoa.setText(App.us.getDni());

        ObservableList<ErabiltzailePuntuatua> puntuList = Atzipena.puntuazioAltuenakLortu();

        puntuTaula.setItems(puntuList);

        idColumn.setCellValueFactory(new PropertyValueFactory("dni"));
        izenaColumn.setCellValueFactory(new PropertyValueFactory("izena"));
        abizenaColumn.setCellValueFactory(new PropertyValueFactory("abizena"));
        adinaColumn.setCellValueFactory(new PropertyValueFactory("adina"));
        okupazioaColumn.setCellValueFactory(new PropertyValueFactory("okupazioa"));
        puntColumn.setCellValueFactory(new PropertyValueFactory("puntuazioa"));
        
    }
}
