package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Srinath on 3/25/2019.
 */
public class SignupController {

    @FXML
    public JFXButton signupBtn;
    @FXML
    public JFXTextField confField;
    @FXML
    public JFXTextField passField;
    @FXML
    public JFXTextField userField;

    @FXML
    public void onSignup() throws SQLException {
        Connection conn = null;
        String url = "jdbc:sqlite:C:\\Users\\Srinath\\com.srinath.coding\\SoftwareDevelopment2019\\SoftwareDev.db";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = conn.createStatement();


        ResultSet rs = statement.executeQuery("select * from users");
        statement.executeUpdate("insert into users (username, password) values('" + userField.getText().toString() + "', '" + passField.getText().toString() + "')");
    }
}
