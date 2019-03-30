package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.app.Habit;
import main.java.app.Var;

import java.io.IOException;
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

    public int number;
    public String freq;
    public Var var = new Var();

    public void insertValues(Habit h, Statement s) {
        try {
            s.executeUpdate("insert into users (id, habitNumber, habitName, habitFreq, habitStreak) values" +
                    "('" + Var.id + "', " +
                    "'" + h.getNumber() + "'," +
                    " '" + h.getTitle() + "', " +
                    "'" + h.getFrequency() + "', " +
                    "'" + h.getStreak() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


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
        var.h1.setNumber(1);
        System.out.println("yuh");
        Parent newh = null;
        try {
            newh = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/NewHabit.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        Scene scene = new Scene(newh, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void habitTwo() {
        number = 2;
        Parent newh = null;
        try {
            newh = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/NewHabit.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        Scene scene = new Scene(newh, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    public void habitThree() {
        number = 3;
        Parent newh = null;
        try {
            newh = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/NewHabit.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        Scene scene = new Scene(newh, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    public void habitFour() {
        number = 4;
        Parent newh = null;
        try {
            newh = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/NewHabit.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        Scene scene = new Scene(newh, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    public void habitFive() {
        number = 5;
        Parent newh = null;
        try {
            newh = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/NewHabit.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        Scene scene = new Scene(newh, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    public void habitSix() {
        number = 6;
        Parent newh = null;
        try {
            newh = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/NewHabit.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        Scene scene = new Scene(newh, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void onHabitClicked() {


        switch (number) {
            case 1:
                var.h1.setId(Var.id);
                var.h1.setNumber(number);
                var.h1.setTitle(habName.getText());
                var.h1.setFrequency(freq);
                var.h1.setStreak(0);
                Stage stage = (Stage) biweekly.getScene().getWindow();
                stage.close();

                break;

            case 2:
                var.h2.setId(Var.id);
                var.h2.setNumber(2);
                var.h2.setTitle(habName.getText());
                var.h2.setFrequency(freq);
                var.h2.setStreak(0);


                break;
            case 3:
                var.h3.setId(Var.id);
                var.h3.setNumber(3);
                var.h3.setTitle(habName.getText());
                var.h3.setFrequency(freq);
                var.h3.setStreak(0);


                break;
            case 4:
                var.h4.setId(Var.id);
                var.h4.setNumber(4);
                var.h4.setTitle(habName.getText());
                var.h4.setFrequency(freq);
                var.h4.setStreak(0);


                break;
            case 5:
                var.h5.setId(Var.id);
                var.h5.setNumber(5);
                var.h5.setTitle(habName.getText());
                var.h5.setFrequency(freq);
                var.h5.setStreak(0);


                break;
            case 6:
                var.h6.setId(Var.id);
                var.h6.setNumber(6);
                var.h6.setTitle(habName.getText());
                var.h6.setFrequency(freq);
                var.h6.setStreak(0);


                break;
            default:
                System.out.println("error");
        }
        System.out.println("yuh");
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

        insertValues(var.h1, statement);
        insertValues(var.h1, statement);
        insertValues(var.h1, statement);
        insertValues(var.h1, statement);
        insertValues(var.h1, statement);
        insertValues(var.h1, statement);



    }


}
