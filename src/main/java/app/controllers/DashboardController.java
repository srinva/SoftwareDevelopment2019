package main.java.app.controllers;

import com.jfoenix.controls.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
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
import javafx.util.Duration;
import main.java.app.Habit;
import main.java.app.Var;
import org.controlsfx.control.Notifications;

import javax.xml.transform.Result;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.util.Date;

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
    @FXML
    public Label points;

    Date today;
    Calendar cal = Calendar.getInstance();
    public int number = 1;
    public String freq;
    public Var var = new Var();
    Timer t = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            points.setText("Points: "+Var.points);
        }
    };


    public void insertValues(Statement s) {
        try {
            s.executeUpdate("insert into habits (id, habitNumber, habitName, habitFreq, habitStreak) values" +
                    "('" + Var.id + "', " +
                    "'" + cal.get(Calendar.DAY_OF_YEAR) + "'," +
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
        //number = 1;
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
    public void onCalc() {
        Parent newh = null;
        try {
            newh = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/Calculator.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        Scene scene = new Scene(newh, 300, 160);
        primaryStage.setScene(scene);
        primaryStage.show();
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
        Statement state = null;
        try {
            stat = con.createStatement();
            state = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //insertValues(statement);
        ResultSet s = null;
        ResultSet rs = null;
        ResultSet ss = null;
        try {
            s = stat.executeQuery("select * from habits");
            rs = stat.executeQuery("select * from habits");
            ss = state.executeQuery("select * from habits");
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


                    JFXCheckBox cb = new JFXCheckBox("Habit Name: " + s.getString("habitName"));
                    Label lbl = new Label("Frequency: "+s.getString("habitFreq"));
                    cb.selectedProperty().addListener(new ChangeListener<Boolean>() {
                        @Override
                        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                            if (cb.isSelected()) {
                                Var.points += 1;
                                points.setText("Points: "+Var.points);
                                cb.setSelected(false);
                            }
                        }
                    });



                    listView.getItems().add(cb);
                    listView.getItems().add(lbl);
                    points.setText("Points: "+Var.points);

                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
