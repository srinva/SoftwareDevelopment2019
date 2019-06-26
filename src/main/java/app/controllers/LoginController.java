package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.app.Var;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import java.util.Random;

public class LoginController {

    @FXML
    public AnchorPane lightBkg;
    @FXML
    public JFXButton loginBtn;
    @FXML
    public JFXTextField userField;
    @FXML
    public JFXPasswordField passField;
    @FXML
    public Label label;
    @FXML
    public Label indicator;
    @FXML
    public JFXButton close;

    @FXML
    public void onClose() {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onLoginClicked() throws SQLException {
        Var.friends.clear();
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(Var.URL, Var.DBU, Var.DBP);
            Statement statement = conn.createStatement();
            Statement statement1 = conn.createStatement();

            ResultSet rs = statement.executeQuery("select * from users");
            ResultSet rs2 = statement1.executeQuery("select * from friends");
            while(rs.next())
            {
                // read the result set
                if (userField.getText().equals(rs.getString("username"))) {
                    System.out.println("username found");
                    if (passField.getText().equals(Crypto.decryptPassword(rs.getString("password")))) {
                        Var.id = rs.getString("id");
                        Var.password = Crypto.decryptPassword(rs.getString("password"));
                        Var.username = rs.getString("username");
                        Var.points = rs.getInt("points");

                        Stage stage = (Stage) lightBkg.getScene().getWindow();
                        stage.close();
                        System.out.println("Succesfully logged in");

                        Parent dash = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/Dashboard.fxml"));
                        Stage primaryStage = new Stage();
                        Scene scene = new Scene(dash, 610, 409);
                        primaryStage.setScene(scene);
                        primaryStage.initStyle(StageStyle.UNIFIED);
                        primaryStage.getIcons().add(new Image("main/java/resources/img/icon.png"));
                        primaryStage.show();

                        break;
                    } else {
                        indicator.setText("Incorrect Password or Username");
                    }
                } else {
                    indicator.setText("Incorrect Password or Username");
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }


    }

    

}
