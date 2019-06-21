package main.java.app.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Srinath on 3/20/2019.
 */
public class LandingPageController implements Initializable {
    @FXML
    public JFXButton signupPort;
    @FXML
    public JFXButton loginPort;
    @FXML
    public ImageView label;
    @FXML
    public JFXButton close;

    @FXML
    public void onClose() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void onLogin() throws IOException {
        Parent log = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/LightLogin.fxml"));
        Stage primaryStage = new Stage();
        Scene scene = new Scene(log, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    @FXML
    public void onSignup() throws IOException {
        Parent log = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/LightSignup.fxml"));
        Stage primaryStage = new Stage();
        Scene scene = new Scene(log, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FadeTransition fadeInLabel = new FadeTransition(Duration.millis(2500), label);
        fadeInLabel.setFromValue(0.0);
        fadeInLabel.setToValue(1.0);
        FadeTransition fadeInSign = new FadeTransition(Duration.millis(2000), signupPort);
        fadeInSign.setFromValue(0.0);
        fadeInSign.setToValue(0.0);
        FadeTransition fadeInSignO = new FadeTransition(Duration.millis(2500), signupPort);
        fadeInSignO.setFromValue(0.0);
        fadeInSignO.setToValue(1.0);
        FadeTransition fadeInLog = new FadeTransition(Duration.millis(2000), loginPort);
        fadeInLog.setFromValue(0.0);
        fadeInLog.setToValue(0.0);
        FadeTransition fadeInLogO = new FadeTransition(Duration.millis(2500), loginPort);
        fadeInLogO.setFromValue(0.0);
        fadeInLogO.setToValue(1.0);
        TranslateTransition tt = new TranslateTransition(Duration.millis(1500), label);
        tt.setByY(51);
        tt.setCycleCount(1);
        tt.setAutoReverse(true);
        TranslateTransition ta = new TranslateTransition(Duration.millis(1500), loginPort);
        ta.setByY(-129);
        ta.setCycleCount(1);
        ta.setAutoReverse(true);
        TranslateTransition ts = new TranslateTransition(Duration.millis(1500), signupPort);
        ts.setByY(-129);
        ts.setCycleCount(1);
        ts.setAutoReverse(true);

        fadeInLabel.play();
        tt.play();
        ts.play();
        ta.play();
        fadeInSign.play();
        fadeInLog.play();
        fadeInSignO.play();
        fadeInLogO.play();


    }
}
