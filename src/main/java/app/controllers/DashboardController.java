package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import main.java.app.Var;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * Created by Srinath on 3/22/2019.
 */
public class DashboardController {

    @FXML
    public JFXButton crtHabit1;
    @FXML
    public JFXButton crtHabit2;
    @FXML
    public JFXButton crtHabit3;
    @FXML
    public JFXButton crtHabit4;
    @FXML
    public JFXButton crtHabit5;
    @FXML
    public JFXButton crtHabit6;
    @FXML
    public JFXTextField habName;
    @FXML
    public JFXRadioButton daily;
    @FXML
    public JFXRadioButton weekly;
    @FXML
    public JFXRadioButton biweekly;
    @FXML
    public JFXRadioButton monthly;

    int number;
    String freq;


    @FXML
    public void onDaily() {
        freq = "d";
    }

    @FXML
    public void onWeekly() {
        freq = "w";
    }

    @FXML
    public void onBi() {
        freq = "b";
    }

    @FXML
    public void onMonthly() {
        freq = "m";
    }

    @FXML
    public void habitOne() {
        number = 1;
    }

    @FXML
    public void habitTwo() {
        number = 2;
    }
    @FXML
    public void habitThree() {
        number = 3;
    }
    @FXML
    public void habitFour() {
        number = 4;
    }
    @FXML
    public void habitFive() {
        number = 5;
    }
    @FXML
    public void habitSix() {
        number = 6;
    }

    @FXML
    public void onHabitClicked() {
        switch (number) {
            case 1:
                Var.h1.setId(Var.id);
                Var.h1.setNumber(1);
                Var.h1.setTitle(habName.getText());
                Var.h1.setFrequency(freq);
                Var.h1.setStreak(0);
                Connection conn = null;
                try {
                    conn = DriverManager.getConnection(Var.LPURL);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Statement statement = null;
                try {
                    statement = conn.createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                /*statement.executeUpdate("insert into users (id, habitNumber, habitName, habitFreq, habitStreak) values('" + Var.id + "', " +
                        "'" + Var.h1.getNumber() + "'," +
                        " '" + Var.h1.get + "')");*/

            case 2:
                Var.h2.setId(Var.id);
                Var.h2.setNumber(2);
                Var.h2.setTitle(habName.getText());
                Var.h2.setFrequency(freq);
                Var.h2.setStreak(0);
            case 3:
                Var.h3.setId(Var.id);
                Var.h3.setNumber(3);
                Var.h3.setTitle(habName.getText());
                Var.h3.setFrequency(freq);
                Var.h3.setStreak(0);
            case 4:
                Var.h4.setId(Var.id);
                Var.h4.setNumber(4);
                Var.h4.setTitle(habName.getText());
                Var.h4.setFrequency(freq);
                Var.h4.setStreak(0);
            case 5:
                Var.h5.setId(Var.id);
                Var.h5.setNumber(5);
                Var.h5.setTitle(habName.getText());
                Var.h5.setFrequency(freq);
                Var.h5.setStreak(0);
            case 6:
                Var.h6.setId(Var.id);
                Var.h6.setNumber(6);
                Var.h6.setTitle(habName.getText());
                Var.h6.setFrequency(freq);
                Var.h6.setStreak(0);
        }
    }


}
