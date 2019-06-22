package main.java.app.controllers;

import com.jfoenix.controls.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.StageStyle;
import javafx.util.Duration;
import main.java.app.Habit;
import main.java.app.Var;
import org.controlsfx.control.Notifications;

import javax.xml.transform.Result;
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
    private JFXListView listView;
    @FXML
    public JFXButton signOut;
    @FXML
    public Label points;
    @FXML
    public JFXButton search;
    @FXML
    public JFXListView leaderboard;

    int lastdate;

    Calendar cal = Calendar.getInstance();

    Timeline tl = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        leaderboard.getItems().clear();
        leaderboard.getItems().add(new Label("Leaderboard"));
        for(int i = 0; i<Var.friends.size(); i++) {
            Label lbl = new Label(""+Var.friends.get(i));
            leaderboard.getItems().add(lbl);

        }
        points.setText("Points: "+Var.points);
        onRefresh();
    }));





    @FXML
    public void onOut() {
        tl.stop();
        Stage stage = (Stage) signOut.getScene().getWindow();
        stage.close();
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
    public void onSearch() {
        Parent newh = null;
        try {
            newh = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/Search.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        Scene scene = new Scene(newh, 300, 160);
        primaryStage.setScene(scene);
        primaryStage.show();
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
            con = DriverManager.getConnection(Var.URL, Var.DBU, Var.DBP);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement stat = null;
        Statement stat2 = null;
        Statement stat3 = null;
        try {
            stat = con.createStatement();
            stat2 = con.createStatement();
            stat3 = con.createStatement();
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
                    JFXButton cb = new JFXButton("" + s.getString("name"));
                    cb.setStyle("-fx-background-color: #646365; ");
                    cb.setTextFill(Color.WHITE);
                    String freq = s.getString("freq");
                    String name = s.getString("name");
                    int streak = Integer.parseInt(s.getString("streak"));
                    lastdate = Integer.parseInt(s.getString("lastdate"));
                    Label lbl = new Label(" Frequency: "+s.getString("freq"));
                    cb.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            if (freq.equals("Daily")) {
                                if (cal.get(Calendar.DAY_OF_YEAR) - lastdate >=1) {
                                    cb.setDisable(true);
                                    lastdate = cal.get(Calendar.DAY_OF_YEAR);
                                    Var.points += 1;
                                    points.setText("Points: "+Var.points);
                                    System.out.println("disabled");
                                } else {
                                    cb.setDisable(false);
                                    System.out.println("enabled");
                                }
                            } else if (freq.equals("Weekly")) {
                                if (cal.get(Calendar.DAY_OF_YEAR) - lastdate >=7) {
                                    cb.setDisable(true);
                                    lastdate = cal.get(Calendar.DAY_OF_YEAR);
                                    Var.points += 1;
                                    points.setText("Points: "+Var.points);
                                    System.out.println("disabled");
                                } else {
                                    cb.setDisable(false);
                                    System.out.println("enabled");
                                }
                            } else if (freq.equals("Biweekly")) {
                                if (cal.get(Calendar.DAY_OF_YEAR) - lastdate >=14) {
                                    cb.setDisable(true);
                                    lastdate = cal.get(Calendar.DAY_OF_YEAR);
                                    Var.points += 1;
                                    points.setText("Points: "+Var.points);
                                    System.out.println("disabled");
                                } else {
                                    cb.setDisable(false);
                                    System.out.println("enabled");
                                }
                            } else if (freq.equals("Weekly")) {
                                if (cal.get(Calendar.DAY_OF_YEAR) - lastdate >=30) {
                                    cb.setDisable(true);
                                    lastdate = cal.get(Calendar.DAY_OF_YEAR);
                                    Var.points += 1;
                                    points.setText("Points: "+Var.points);
                                    System.out.println("disabled");
                                } else {
                                    cb.setDisable(false);
                                    System.out.println("enabled");
                                }
                            }
                        }
                    });


                    stat3.executeUpdate("update habits set lastdate = "+cal.get(Calendar.DAY_OF_YEAR)+" where id = "+Var.id+" AND name = '"+name+"'");

                    if (freq.equals("Daily")) {
                        if (cal.get(Calendar.DAY_OF_YEAR) - Integer.parseInt(s.getString("lastdate")) >= 1) {
                            cb.setDisable(false);
                            System.out.println("enabled A");
                        }
                    } else if (freq.equals("Weekly")) {
                        if (cal.get(Calendar.DAY_OF_YEAR) - Integer.parseInt(s.getString("lastdate")) >= 7) {
                            cb.setDisable(false);
                            System.out.println("enabled b");
                        }
                    } else if (freq.equals("Biweekly")) {
                        if (cal.get(Calendar.DAY_OF_YEAR) - Integer.parseInt(s.getString("lastdate")) >= 14) {
                            cb.setDisable(false);
                            System.out.println("enabled c");
                        }
                    } else if (freq.equals("Weekly")) {
                        if (cal.get(Calendar.DAY_OF_YEAR) - Integer.parseInt(s.getString("lastdate")) >= 30) {
                            cb.setDisable(false);
                            System.out.println("enabled d");
                        }
                    }



                    listView.getItems().add(cb);
                    listView.getItems().add(lbl);
                    points.setText("Points: "+Var.points);
                    stat2.executeUpdate("update users set points = "+Var.points+" where id = "+Var.id);

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
        try {
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        leaderboard.getItems().clear();
        leaderboard.getItems().add(new Label("Leaderboard"));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
    }
}
