package main.java.app.controllers;

import com.jfoenix.controls.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.java.app.Habit;
import main.java.app.Var;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.*;

/**
 * Created by Srinath on 3/22/2019.
 */
public class DashboardController implements Initializable {

    @FXML
    public JFXButton crtHabit1;
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
    private JFXListView listView;
    @FXML
    public JFXButton signOut;

    public int number = 1;
    public String freq;
    public Var var = new Var();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            listView.getItems().clear();
            Connection con = null;
            try {
                con = DriverManager.getConnection(Var.LPURL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stat = null;
            try {
                stat = con.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //insertValues(statement);
            ResultSet s = null;
            try {
                s = stat.executeQuery("select * from habits");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ;
            try {
                while(s.next())
                {

                    // read the result set
                    if (Var.id.equals(s.getString("id"))) {
                        //System.out.println("Habit Name: " + rs.getString("habitName"));

                        listView.getItems().add(new JFXCheckBox("Habit Name: " + s.getString(("habitName"))));
                        listView.getItems().add(new Label("Frequency: "+s.getString("habitFreq")));
                    }


                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    };
    Timer t = new Timer();

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
    public void onOut() {
        Stage stage = (Stage) signOut.getScene().getWindow();
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

        }



        Stage stage = (Stage) biweekly.getScene().getWindow();
        stage.close();





    }

    @FXML
    public void onRefresh() {
        listView.getItems().clear();
        Connection con = null;
        try {
            con = DriverManager.getConnection(Var.LPURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement stat = null;
        try {
            stat = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //insertValues(statement);
        ResultSet s = null;
        try {
            s = stat.executeQuery("select * from habits");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
        try {
            while(s.next())
            {

                // read the result set
                if (Var.id.equals(s.getString("id"))) {
                    //System.out.println("Habit Name: " + rs.getString("habitName"));

                    listView.getItems().add(new JFXCheckBox("Habit Name: " + s.getString(("habitName"))));
                    listView.getItems().add(new Label("Frequency: "+s.getString("habitFreq")));
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
