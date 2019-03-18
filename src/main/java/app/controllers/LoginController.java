package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    public static JFXTextField userField;
    @FXML
    public static JFXPasswordField passField;
    @FXML
    public static Label label;

    @FXML
    public void onLoginClicked() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:S:\\SoftwareDevelopment2019\\SoftwareDev.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();

            System.out.println("Connection to SQLite has been established.");

            ResultSet rs = statement.executeQuery("select * from users");
            while(rs.next())
            {
                // read the result set
                System.out.println("username = " + rs.getString("username"));
                System.out.println("password = " + rs.getString("password"));
                Var.username = rs.getString(0);
                Var.password = rs.getString(0);
                if (Var.username.equals(userField.getText())) {
                    if (Var.password.equals(passField.getText())) {
                        System.out.println("login successful");
                    } else {
                        System.out.println("incorrect password");
                        break;
                    }
                } else {
                    System.out.println("login failed");
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
