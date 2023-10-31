package com.example.itrack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    // Hey abba
    @Override
    public void start(Stage stage) throws IOException {
       BorderPane root = new BorderPane();


        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("iTrack");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}