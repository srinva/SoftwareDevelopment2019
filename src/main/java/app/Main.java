package main.java.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.app.controllers.Crypto;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/main/java/resources/scene/LandingPage.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.getIcons().add(new Image("main/java/resources/img/icon.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        System.out.println(Crypto.encryptPassword("srinath"));
        launch(args);
    }
}
