package com.example.itrack;

import com.example.itrack.Constants.ScreenRatio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    // Hey abba
    //Hello brock
    @Override
    public void start(Stage stage) throws IOException {
       BorderPane root = new BorderPane();

        //Mayo De Noche
        Scene scene = new Scene(root,ScreenRatio.SCREEN_WIDTH, ScreenRatio.SCREEN_HEIGHT);
        stage.setTitle("iTrack");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}