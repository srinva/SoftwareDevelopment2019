package main.java.app.controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Methods {

    public static void updateHabits(ListView listView, ResultSet s) {
        JFXCheckBox name = null;
        try {
            name = new JFXCheckBox(""+s.getString("habitName"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Label freq = null;
        try {
            freq = new Label("Frequency: "+s.getString("habitFreq"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //freq.setStyle("-fx-font-weight: bold");
        name.setFont(Font.font("System", 18));
        name.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }
        });


        listView.getItems().add(name);
        //listView.getItems().add(1, freq);
    }

}
