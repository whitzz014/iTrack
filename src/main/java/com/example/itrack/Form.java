package com.example.itrack;

import com.example.itrack.Constants.ScreenRatio;
import com.example.itrack.tabs.TrackerTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Form extends Application {

    // Hey abba
    //Hello brock
    @Override
    public void start(Stage stage) throws IOException {
       BorderPane root = new BorderPane();
//create tabPane
        TabPane tabPane = new TabPane();
        //Create the tabs

//        AddItemTab addItemTab = new AddItemTab();
        TrackerTab addItemTab = TrackerTab.getInstance();//replaced with singleton form so we dont have to create new objected we commented out above
        addItemTab.setClosable(false);


        tabPane.getTabs().addAll(addItemTab);

        root.setBottom(tabPane);
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