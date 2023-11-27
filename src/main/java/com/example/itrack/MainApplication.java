/**
 * Name: iTrack
 * created by: Brock Whitson and Ali Mehdi
 * description: Macro Nutrient tracker that can be set to help you reach the users goals.
 */
package com.example.itrack;


import com.example.itrack.Constants.ScreenRatio;

import com.example.itrack.database.Database;

import com.example.itrack.scenes.AccountScene;
import com.example.itrack.scenes.FormScene;
import com.example.itrack.scenes.SettingsScene;
import com.example.itrack.scenes.SignupScene;
import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {


    //File options
    public static  MenuBar menu = new MenuBar();

    public static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        Menu fileMenu = new Menu("File");

        //account option
        MenuItem accountMenu = new MenuItem("Account");
        //TODO-> sends to account info pane
            accountMenu.setOnAction(e->{
                MainApplication.mainStage.setScene(new AccountScene());
            });
        //settings option
        MenuItem settingsMenu = new MenuItem("Settings");
        //send to settings pane
        settingsMenu.setOnAction(e->{
            MainApplication.mainStage.setScene(new SettingsScene());
        });
        //exit app button
        MenuItem exit = new MenuItem("Close Application");
        exit.setOnAction(e->{
            System.exit(0);
        });

        MenuItem signup = new MenuItem("SIGNUP");
        signup.setOnAction(event -> {
            mainStage.setScene(new SignupScene());
        });

        //Tracker Menu Item
        Menu navMenu = new Menu("iNavigation");
        MenuItem formItem = new MenuItem("Tracker");
        formItem.setOnAction(e->{
            MainApplication.mainStage.setScene(new FormScene());
        });

        navMenu.getItems().addAll(formItem);

        //credits
        Menu creditsMenu = new Menu("Credits");
        MenuItem ideUsed = new MenuItem("IDE: IntelliJ");
        MenuItem founderOne = new MenuItem("Ali Mehdi");
        MenuItem founderTwo = new MenuItem("Brock Whitson");

        creditsMenu.getItems().addAll(founderOne,founderTwo, ideUsed);
        fileMenu.getItems().addAll(accountMenu, settingsMenu, signup,exit);
        menu.getMenus().addAll(fileMenu, navMenu, creditsMenu);
        //Mayo De Noche

        Database.getInstance();

    //connect stage to mainStage
      mainStage = stage;
      //so user cant adjust application size
      mainStage.setResizable(false);

      //connect FormScene so it is the main scene
      mainStage.setScene(new SignupScene());
      mainStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}