package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Srinath on 3/20/2019.
 */
public class LandingPageController {
    @FXML
    public JFXButton signupPort;
    @FXML
    public JFXButton loginPort;

    @FXML
    public void onLogin() throws IOException {
        Parent log = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/LightLogin.fxml"));
        Stage primaryStage = new Stage();
        Scene scene = new Scene(log, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void onSignup() {

    }
}
