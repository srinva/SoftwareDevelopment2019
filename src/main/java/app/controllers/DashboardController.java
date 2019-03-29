package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import main.java.app.Var;

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

    int number;


    @FXML
    public void habitOne() {
        number = 1;
    }

    @FXML
    public void habitTwo() {
        number = 2;
    }
    @FXML
    public void habitThree() {
        number = 3;
    }
    @FXML
    public void habitFour() {
        number = 4;
    }
    @FXML
    public void habitFive() {
        number = 5;
    }
    @FXML
    public void habitSix() {
        number = 6;
    }

    @FXML
    public void onHabitClicked() {
        switch (number) {
            case 1:
                Var.h1.setNumber(1);
                Var.h1.setTitle(habName.getText());
            case 2:
                Var.h2.setNumber(2);
                Var.h2.setTitle(habName.getText());
            case 3:
                Var.h3.setNumber(3);
                Var.h3.setTitle(habName.getText());
            case 4:
                Var.h4.setNumber(4);
                Var.h4.setTitle(habName.getText());
            case 5:
                Var.h5.setNumber(5);
                Var.h5.setTitle(habName.getText());
            case 6:
                Var.h6.setNumber(6);
                Var.h6.setTitle(habName.getText());
        }
    }


}
