package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXPasswordField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import main.java.app.Var;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Created by Srinath on 3/25/2019.
 */
public class SignupController implements Initializable {

    @FXML
    public JFXButton signupBtn;
    @FXML
    public JFXPasswordField confField;
    @FXML
    public JFXPasswordField passField;
    @FXML
    public JFXTextField userField;
    @FXML
    public Label indicator;



    @FXML
    public void onSignup() throws SQLException {
        if (userField.getText().equals("") || passField.getText().equals("")) {
            indicator.setText("Username or Password is empty");
        } else {
            if (confField.getText().equals(passField.getText())) {
                Connection conn = null;
                String url = "jdbc:sqlite:C:\\Users\\Srinath\\com.srinath.coding\\SoftwareDevelopment2019\\SoftwareDev.db";
                try {
                    conn = DriverManager.getConnection(Var.PCURL);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Statement statement = conn.createStatement();


                statement.executeUpdate("insert into users (username, password) values('" + userField.getText().toString() + "', '" + passField.getText().toString() + "')");


            } else {
                indicator.setText("Make sure passwords match");
            }
        }
      }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
