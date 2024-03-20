package dambat.controller;

import java.io.IOException;
import java.util.ArrayList;

import dambat.App;
import dambat.model.Atzipena;
import dambat.model.ErabiltzailePuntuatua;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * Puntuazio altuenen grafikoa eraikitzeko beharrezkoak diren funtzioak batzen dituen controller-a
 * @author Julen Herrero
 */
public class Grafikoacontroller {
    
    @FXML
    BarChart <String, Integer> pGrafikoa;

    @FXML
    CategoryAxis x;

    @FXML
    NumberAxis y;

    /**
     * Funtzio honek grafikoa betetzen du, XYChart serie bat lortzen du beste funtzio bati deituz eta hori grafikoa eraikitzeko erabiltzen du
     * @throws IOException
     */
    public void grafikoaBete() throws IOException {

        XYChart.Series<String, Integer> serie1 = new XYChart.Series<>(); 

        Atzipena.grafikoarenDatuakLortu(serie1);

        serie1.setName("Erabiltzaileak");

        pGrafikoa.getData().addAll(serie1);
    }

    /**
     * Funtzio honek menu nagusira bueltatzen dio erabiltzaileari
     * @throws IOException
     */
    public void backMenu() throws IOException {
        App.setRoot("aukeramenua");
    }
}
