package main.java.app.controllers;

import com.jfoenix.controls.*;
import com.sun.org.apache.regexp.internal.RE;
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
import javafx.scene.image.Image;
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

    Timeline tl = new Timeline(new KeyFrame(Duration.millis(1250), event -> {
        leaderboard.getItems().clear();
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
    public void onDist() {
        System.out.println("yuh");
        Parent newh = null;
        try {
            newh = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/PointDistribution.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        Scene scene = new Scene(newh, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.getIcons().add(new Image("main/java/resources/img/icon.png"));
        primaryStage.show();
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
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.getIcons().add(new Image("main/java/resources/img/icon.png"));
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
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.getIcons().add(new Image("main/java/resources/img/icon.png"));
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
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.getIcons().add(new Image("main/java/resources/img/icon.png"));
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

        try {
            stat = con.createStatement();
            stat2 = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //insertValues(statement);
        ResultSet s = null;
        ResultSet s1 = null;
        try {
            s = stat.executeQuery("select * from habits");
            s1 = stat2.executeQuery("select * from users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
        try {

            while (s1.next()) {
                if (Var.id.equals(s1.getString("id"))) {
                    Var.points = Integer.parseInt(s1.getString("points"));
                }
            }

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


                            Calendar c = Calendar.getInstance();
                            Connection conn = null;
                            try {
                                conn = DriverManager.getConnection(Var.URL, Var.DBU, Var.DBP);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            Statement stat3 = null;
                            Statement stat4 = null;
                            Statement stat5 = null;
                            Statement stat6 = null;
                            try {
                                stat3 = conn.createStatement();
                                stat4 = conn.createStatement();
                                stat5 = conn.createStatement();
                                stat6 = conn.createStatement();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            ResultSet rs = null;
                            ResultSet rs1 = null;
                            try {
                                rs = stat3.executeQuery("select * from habits");
                                rs1 = stat6.executeQuery("select * from users");
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                            try {
                                while(rs.next()) {

                                    if (Var.id.equals(rs.getString("id"))) {

                                        /*if (rs.getString("freq").equals("Daily")) {
                                            if (cal.get(Calendar.DAY_OF_YEAR) - (Integer.parseInt(rs.getString("lastdate"))) >= 1) {

                                                stat5.executeUpdate("update habits set lastdate = '" +
                                                        (c.get(Calendar.DAY_OF_YEAR))
                                                        + "' where name = '" + name + "' AND id = " + Var.id);
                                                cb.setDisable(true);
                                            }
                                        }*/

                                        try {

                                            stat4.executeUpdate("update habits set streak = '" +
                                                    ((Integer.parseInt(rs.getString("streak"))) + 1)
                                                    + "' where name = '" + name + "' AND id = " + Var.id);

                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                }

                                Var.points += 1;
                                points.setText("Points: "+Var.points);
                                stat5.executeUpdate("update users set points = "+Var.points+" where id = "+Var.id);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }


                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            try {
                                rs.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        }
                    });

                    //stat4.executeUpdate("set SQL_SAFE_UPDATES = 0");
                    //stat3.executeUpdate("update habits set lastdate = "+200+" where id = "+Var.id+" AND name = '"+name+"'");

                    /*if (s.getString("freq").equals("Daily")) {
                        if (Integer.parseInt(s.getString("lastdate")) >= 1) {
                            cb.setDisable(false);
                        } else {
                            cb.setDisable(true);
                        }
                    }*/

                    listView.getItems().add(cb);
                    listView.getItems().add(lbl);



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
    public void initialize(URL location, ResourceBundle resources){
        leaderboard.getItems().clear();
        Var.friends.clear();
        Connection con = null;
        try {
            con = DriverManager.getConnection(Var.URL, Var.DBU, Var.DBP);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement s = null;
        try {
            s = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement s2 = null;
        try {
            s2 = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = s.executeQuery("select * from friends");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs2 = null;
        try {
            rs2 = s2.executeQuery("select * from users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                rs2 = s2.executeQuery("select * from users");
                if (rs.getString("id").equals(Var.id)) {
                    while(rs2.next()) {
                        if(rs2.getString("id").equals(rs.getString("fid"))) {
                            Var.friends.add(rs2.getString("username")+": "+rs2.getInt("points")+" points");
                            System.out.println(Var.friends);
                        } else {
                            //System.out.println("oof");
                        }
                    }
                } else {
                    //System.out.println("ooof");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i = 0; i<Var.friends.size(); i++) {
            Label lbl = new Label(""+Var.friends.get(i));
            leaderboard.getItems().add(lbl);

        }
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
    }
}
