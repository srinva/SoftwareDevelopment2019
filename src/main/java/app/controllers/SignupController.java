package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXPasswordField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.java.app.Var;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Created by Srinath on 3/25/2019.
 */
public class SignupController implements Initializable {

    @FXML
    public AnchorPane lightBkg;
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
                try {
                    conn = DriverManager.getConnection(Var.LPURL);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Statement statement = conn.createStatement();

                int id = new Random().nextInt(10000);
                Var.id = String.valueOf(id);

                statement.executeUpdate("insert into users (id, username, password) values('" + Var.id
                        + "', '" + userField.getText().toString() + "', '" + passField.getText().toString() + "')");

                Stage stage = (Stage) lightBkg.getScene().getWindow();
                stage.close();

            } else {
                indicator.setText("Make sure passwords match");
            }
        }
      }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
