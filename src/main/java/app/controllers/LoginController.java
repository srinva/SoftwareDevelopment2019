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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.app.DBConnect;
import main.java.app.Var;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    @FXML
    public static JFXButton loginBtn;
    @FXML
    public JFXTextField userField;
    @FXML
    public JFXPasswordField passField;
    @FXML
    public static Label label;

    @FXML
    public void onLoginClicked() throws SQLException {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Srinath\\com.srinath.coding\\SoftwareDevelopment2019\\SoftwareDev.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();

            System.out.println("Connection to SQLite has been established.");

            ResultSet rs = statement.executeQuery("select * from users");
            while(rs.next())
            {
                // read the result set
                if (userField.getText().equals(rs.getString("username"))) {
                    System.out.println("username found");
                    if (passField.getText().equals(rs.getString("password"))) {
                        System.out.println("Succesfully logged in");
                        Parent dash = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/LandingPage.fxml"));
                        Stage primaryStage = new Stage();
                        Scene scene = new Scene(dash, 600, 400);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        break;
                    } else {
                        System.out.print("incorrect password or username");
                    }
                } else {
                    System.out.println("incorrect password or username");
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
