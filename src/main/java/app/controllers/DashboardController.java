package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
                Var.h1.setId(Var.id);
                Var.h1.setNumber(1);
                Var.h1.setTitle(habName.getText());
                Var.h1.setFrequency(freq);
                Var.h1.setStreak(0);
                Stage stage = (Stage) biweekly.getScene().getWindow();
                stage.close();

                break;

            case 2:
                Var.h2.setId(Var.id);
                Var.h2.setNumber(2);
                Var.h2.setTitle(habName.getText());
                Var.h2.setFrequency(freq);
                Var.h2.setStreak(0);


                break;
            case 3:
                Var.h3.setId(Var.id);
                Var.h3.setNumber(3);
                Var.h3.setTitle(habName.getText());
                Var.h3.setFrequency(freq);
                Var.h3.setStreak(0);


                break;
            case 4:
                Var.h4.setId(Var.id);
                Var.h4.setNumber(4);
                Var.h4.setTitle(habName.getText());
                Var.h4.setFrequency(freq);
                Var.h4.setStreak(0);


                break;
            case 5:
                Var.h5.setId(Var.id);
                Var.h5.setNumber(5);
                Var.h5.setTitle(habName.getText());
                Var.h5.setFrequency(freq);
                Var.h5.setStreak(0);


                break;
            case 6:
                Var.h6.setId(Var.id);
                Var.h6.setNumber(6);
                Var.h6.setTitle(habName.getText());
                Var.h6.setFrequency(freq);
                Var.h6.setStreak(0);


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
        try {
            statement.executeUpdate("insert into users (id, habitNumber, habitName, habitFreq, habitStreak) values" +
                    "('" + Var.id + "', " +
                    "'" + Var.h1.getNumber() + "'," +
                    " '" + Var.h1.getTitle() + "', " +
                    "'" + Var.h1.getFrequency() + "', " +
                    "'" + Var.h1.getFrequency() + "', " +
                    "'" + Var.h1.getStreak() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.executeUpdate("insert into users (id, habitNumber, habitName, habitFreq, habitStreak) values" +
                    "('" + Var.id + "', " +
                    "'" + Var.h2.getNumber() + "'," +
                    " '" + Var.h2.getTitle() + "', " +
                    "'" + Var.h2.getFrequency() + "', " +
                    "'" + Var.h2.getFrequency() + "', " +
                    "'" + Var.h2.getStreak() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.executeUpdate("insert into users (id, habitNumber, habitName, habitFreq, habitStreak) values" +
                    "('" + Var.id + "', " +
                    "'" + Var.h3.getNumber() + "'," +
                    " '" + Var.h3.getTitle() + "', " +
                    "'" + Var.h3.getFrequency() + "', " +
                    "'" + Var.h3.getFrequency() + "', " +
                    "'" + Var.h3.getStreak() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.executeUpdate("insert into users (id, habitNumber, habitName, habitFreq, habitStreak) values" +
                    "('" + Var.id + "', " +
                    "'" + Var.h4.getNumber() + "'," +
                    " '" + Var.h4.getTitle() + "', " +
                    "'" + Var.h4.getFrequency() + "', " +
                    "'" + Var.h4.getFrequency() + "', " +
                    "'" + Var.h4.getStreak() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.executeUpdate("insert into users (id, habitNumber, habitName, habitFreq, habitStreak) values" +
                    "('" + Var.id + "', " +
                    "'" + Var.h5.getNumber() + "'," +
                    " '" + Var.h5.getTitle() + "', " +
                    "'" + Var.h5.getFrequency() + "', " +
                    "'" + Var.h5.getFrequency() + "', " +
                    "'" + Var.h5.getStreak() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.executeUpdate("insert into users (id, habitNumber, habitName, habitFreq, habitStreak) values" +
                    "('" + Var.id + "', " +
                    "'" + Var.h6.getNumber() + "'," +
                    " '" + Var.h6.getTitle() + "', " +
                    "'" + Var.h6.getFrequency() + "', " +
                    "'" + Var.h6.getFrequency() + "', " +
                    "'" + Var.h6.getStreak() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
