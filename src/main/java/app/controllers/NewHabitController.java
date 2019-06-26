package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import main.java.app.Var;

import java.io.IOException;
import java.sql.*;
import java.util.Calendar;

public class NewHabitController {


    public String freq;
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
    @FXML
    public JFXButton close;

    int streak;

    Calendar cal = Calendar.getInstance();

    public void insertValues(Statement s) {
        int day = cal.get(Calendar.DAY_OF_YEAR);
        int tday = day-1;
        try {
            s.executeUpdate("insert into habits (id, name, freq, streak, lastdate, number) values" +
                    "(" + Var.id + ", " +
                    " '" + habName.getText() + "', " +
                    "'" + freq + "', " +
                    "'" + 0 + "'," +
                    "'" + tday + "'," +
                    "'" + (cal.get(Calendar.DAY_OF_YEAR)-1) + "')");
            System.out.println(tday);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onClose() {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onDaily() {
        freq = "Daily";
    }

    @FXML
    public void onWeekly() {
        freq = "Weekly";
    }

    @FXML
    public void onBi() {
        freq = "Biweekly";
    }

    @FXML
    public void onMonthly() {
        freq = "Monthly";
    }

    @FXML
    public void onHabitClicked() throws SQLException, IOException {

        System.out.println("yuh");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Var.URL, Var.DBU, Var.DBP);
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
        }


        Stage stage = (Stage) biweekly.getScene().getWindow();
        stage.close();




    }


}
