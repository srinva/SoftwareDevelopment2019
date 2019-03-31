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
import java.sql.*;
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

    public int number = 1;
    public String freq;
    public Var var = new Var();

    public void insertValues(Statement s) {
        try {
            s.executeUpdate("insert into habits (id, habitNumber, habitName, habitFreq, habitStreak) values" +
                    "('" + Var.id + "', " +
                    "'" + number + "'," +
                    " '" + habName.getText() + "', " +
                    "'" + freq + "', " +
                    "'" + 0 + "')");
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
    public void onHabitClicked() throws SQLException, IOException {


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
        //insertValues(statement);
        int count = 0;
        ResultSet rs = statement.executeQuery("select * from habits");
        while(rs.next())
        {

            // read the result set
            if (Var.id.equals(rs.getString("id"))) {
                //System.out.println("Habit Name: " + rs.getString("habitName"));
                count++;
            }


        }

        if (count >= 6) {
            System.out.println("You cannot create any more habits currently");

        } else {
            insertValues(statement);
            ResultSet s = statement.executeQuery("select * from habits");
            while(s.next())
            {

                // read the result set
                if (Var.id.equals(s.getString("id"))) {
                    System.out.println("Habit Name: " + s.getString("habitName"));

                }


            }
        }



        Stage stage = (Stage) biweekly.getScene().getWindow();
        stage.close();





    }


}
