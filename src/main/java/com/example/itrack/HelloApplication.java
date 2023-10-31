package com.example.itrack;

import com.example.itrack.Constants.ScreenRatio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    // Hey abba
    //Hello brock
    @Override
    public void start(Stage stage) throws IOException {
       BorderPane root = new BorderPane();
        //add menu bar
        MenuBar menu = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu creditsMenu = new Menu("Credits");
        MenuItem exit = new MenuItem("Close Application");
        exit.setOnAction(e->{
            System.exit(0);
        });

        //credits
        MenuItem founderOne = new MenuItem("Ali Mehdi");
        MenuItem founderTwo = new MenuItem("Brock Whitson");
        //add credits to tab
        creditsMenu.getItems().addAll(founderOne,founderTwo);

        fileMenu.getItems().addAll(exit);
        menu.getMenus().addAll(fileMenu,creditsMenu);
        root.setTop(menu);
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