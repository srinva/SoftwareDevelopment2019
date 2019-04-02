package main.java.app.controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.util.Duration;
import main.java.app.Var;
import org.controlsfx.control.Notifications;

public class CalculatorController {

    @FXML
    public JFXTextField minField;

    @FXML
    public void onConfirm() {
        Var.min = Double.parseDouble(minField.getText());
        Notifications.create()
                .title("Calculated")
                .text("It will take at least "+Math.round(Var.calculateDays(Var.min))+" days to complete")
                .hideAfter(Duration.seconds(5))
                .showConfirm();
    }
}
