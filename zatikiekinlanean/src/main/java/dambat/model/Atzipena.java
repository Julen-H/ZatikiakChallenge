package dambat.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 * Datu basera konekzioa egiteko beharrezko funtzioak batzen dituen klasea
 * @author Julen Herrero
 */
public class Atzipena {

    /**
     * Metodo honek SQLite-ko datu basera konekzioa egiten du url bidez, ez badu konekzioa lortzen exception baten bidez mezu bat jasoko da
     * @return Connection motatako obkejtu bat bueltatzen du, bertan konexioa gordez
     */
    public static Connection konektatu() {

        Connection conn = null;
        String url = "jdbc:sqlite:erabiltzaileak.db";

        try {
            
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException ex) {

            System.out.println(ex.getErrorCode() + "-" + ex.getMessage());
        }
            return conn;
        }

    /**
     * Funtzioak jasotako dni hori duen erabiltzaile baten datu denak hartzen ditu datu basetik sql sententzia baten bitartez. 
     * Datu horiekin objektu bat sortzen du konstruktorearen bitartez eta objektu hori bueltatzen du, gainera bueltatu baino lehen
     * zein motatakoa den identifikatzen du
     * @return Erabiltzaile klaseko edo Ikasle klaseko objektu bat bueltatzen du
     * @param String motako parametro bat jasotzen du; logeatzea nahi duen erabiltzaileak login-ean idatzi duen dni-a String moduan
     */
    public static Erabiltzailea erabiltzaileaLortu(String dni) {

        Erabiltzailea objektu1 = null;
            
        String eremua = "";

        String sql = "SELECT * FROM erabiltzailea WHERE dni = " + "'" + dni + "'";

        try (Connection conn = konektatu();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

                ResultSet rs = pstmt.executeQuery();
                rs.next();
                //System.out.println("Pasahitza hau da: " + rs.getString(1));

                eremua = rs.getString(1);

                if (rs.getString(8).equalsIgnoreCase("Ikaslea")) {

                    Ikaslea k1 = new Ikaslea(rs.getString(1), rs.getString(2), rs.getString(3), 
                    rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), 
                    rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                    System.out.println(k1);
                    objektu1 = k1;
                    
                } else {
                    
                    Erabiltzailea e1 = new Erabiltzailea(rs.getString(1), rs.getString(2), rs.getString(3), 
                    rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), 
                    rs.getString(8));
                    System.out.println(e1);
                    objektu1 = e1;
                }
                    
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return objektu1;
        }

    /**
     * Funtzio honek jasotzen dituen parametro guztiak datu basean txertatzen ditu kontu bat sortzeko eta erabiltzailea logeatu ahal izateko.
     * Horretarako sql sententzia bidez insert bat egiten du datu basean
     * @param String motako hamar parametro eta int motako parametro bat jasotzen du, parametro hauek kontua sortzen ari den erabiltzailearen datu guztiak dira
     */
    public static void erregistratuKontua(String balorea1, String balorea2, String balorea3, int balorea4, 
    String balorea5, String balorea6, String balorea7, String balorea8, String balorea9, String balorea10, String balorea11) {

        String eremua1 = "dni";
        String eremua2 = "izena";
        String eremua3 = "abizena";
        String eremua4 = "adina";
        String eremua5 = "emaila";
        String eremua6 = "telefonoa";
        String eremua7 = "pasahitza";
        String eremua8 = "okupazioa";
        String eremua9 = "ikasketak";
        String eremua10 = "zentroa";
        String eremua11 = "ikasle_mota";

        String taula = "erabiltzailea";

        String sql = "INSERT INTO " + taula + "(" + eremua1 + ", " + eremua2 + ", " + eremua3 + ", " + eremua4 + ", " + eremua5 + ", " + eremua6 + 
        ", " + eremua7 + ", " + eremua8 + ", " + eremua9 + ", " + eremua10 + ", " + eremua11 + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?)";

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, balorea1);
            pstmt.setString(2, balorea2);
            pstmt.setString(3, balorea3);
            pstmt.setInt(4, balorea4);
            pstmt.setString(5, balorea5);
            pstmt.setString(6, balorea6);
            pstmt.setString(7, balorea7);
            pstmt.setString(8, balorea8);
            pstmt.setString(9, balorea9);
            pstmt.setString(10, balorea10);
            pstmt.setString(11, balorea11);
            pstmt.executeUpdate();
            System.out.println("Puntuazioa ondo txertatu da.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Funtzio honek erabiltzaile baten puntuazioa erregistratzen du datu basean. 
     * Azterketa egin eta gero atera duen puntuazioa eta oinarrizko datu pertsonal batzuk hartzen ditu datu basean txertatzeko sql sententzia baten bidez
     * @param String motako bost parametro eta int motako parametro bat jasotzen du
     */
    public static void erregistratuPuntuazioa(String balorea1, String balorea2, String balorea3, String balorea4, String balorea5, int balorea6) {
        
        String eremua1 = "dni";
        String eremua2 = "izena";
        String eremua3 = "abizena";
        String eremua4 = "adina";
        String eremua5 = "okupazioa";
        String eremua6 = "puntuazioa";

        String taula = "puntuazioa";

        String sql = "INSERT OR REPLACE INTO " + taula + "(" + eremua1 + ", " + eremua2 + ", " + eremua3 + ", " + eremua4 + ", " + 
        eremua5 + ", " + eremua6 + ") VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, balorea1);
            pstmt.setString(2, balorea2);
            pstmt.setString(3, balorea3);
            pstmt.setString(4, balorea4);
            pstmt.setString(5, balorea5);
            pstmt.setInt(6, balorea6);
            pstmt.executeUpdate();
            System.out.println("Puntuazioa ondo txertatu da.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }   
    
    /**
     * Funtzioak puntuazio altuenak jasotzen ditu datu basetik sql sententzia baten bidez eta objektuak sortzen ditu 7 baino gehiago atera dituen erabiltzaile bakoitzeko.
     * Behin objektuak sortuta ObservableList-ean sartzen ditu eta lista hori bueltatzen du
     * @return Funtzioak ErabiltzailePuntuatua motako ObservableList bat bueltatzen du table view bat sortzeko
     */
    public static ObservableList<ErabiltzailePuntuatua> puntuazioAltuenakLortu() throws IOException {

        String eremua1 = "dni";
        String eremua2 = "izena";
        String eremua3 = "abizena";
        String eremua4 = "adina";
        String eremua5 = "okupazioa";
        String eremua6 = "puntuazioa";

        ObservableList<ErabiltzailePuntuatua> puntuazioList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM puntuazioa WHERE puntuazioa >= " + 7 + " ORDER BY puntuazioa DESC";

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {

                puntuazioList.add(new ErabiltzailePuntuatua(rs.getString(eremua1), rs.getString(eremua2), rs.getString(eremua3), rs.getInt(eremua4),
                    rs.getString(eremua5), rs.getInt(eremua6)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return puntuazioList;
    }

    /**
     * Funtzioak puntuazio altuenak atera dituzten erabiltzaileen dni-ak eta puntuazioak jasotzen ditu eta XYChart seriean kargatzen ditu datuak.
     * Azkenik XYChart seriea bueltatzen du BarChart bat sortzeko
     * @param XYChart serie bat jasotzen du
     */
    public static void grafikoarenDatuakLortu(XYChart.Series serie1) throws IOException {

        String sql = "SELECT dni, puntuazioa FROM puntuazioa WHERE puntuazioa >= " + 7 + " ORDER BY puntuazioa DESC";

        try (Connection conn = konektatu(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                String dni = rs.getString("dni");
                int punt = rs.getInt("puntuazioa");

                serie1.getData().add(new XYChart.Data<>(dni,punt));
                
            }
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
    

