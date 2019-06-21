package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.java.app.Var;
import org.controlsfx.control.Notifications;

import javax.management.Notification;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Created by Srinath on 4/2/2019.
 */
public class SearchController implements Initializable {

    @FXML
    public Label idLbl;
    @FXML
    public JFXButton search;
    @FXML
    public JFXTextField userField;
    @FXML
    public JFXButton close;

    @FXML
    public void onClose() {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onSearch() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Var.URL, Var.DBU, Var.DBP);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //System.out.println("Connection to SQLite has been established.");

        ResultSet rs = null;
        try {
            rs = statement.executeQuery("select * from users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(rs.next())
            {
                if (userField.getText().equals(rs.getString("id"))) {
                    Notifications.create()
                            .title("The user has "+rs.getString("points")+" points")
                            .hideAfter(Duration.seconds(5))
                            .text("Keep going!")
                            .showConfirm();
                    Var.friends.add(""+rs.getString("username")+": "+rs.getInt("points")+" points");
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idLbl.setText("Your id is: "+Var.id);
        System.out.print(""+Var.id);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Var.URL, Var.DBU, Var.DBP);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            statement.executeUpdate("update users set points = "+Var.points+" where id = "+Var.id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
