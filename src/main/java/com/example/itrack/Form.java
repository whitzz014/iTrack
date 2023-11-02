/**
 * Name: iTrack
 * created by: Brock Whitson and Ali Mehdi
 * description: Macro Nutrient tracker that can be set to help you reach the users goals.
 */
package com.example.itrack;

import com.example.itrack.Constants.ScreenRatio;
import com.example.itrack.tabs.TrackerTab;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.control.TabPane;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Form extends Application {

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

        //add menu bar
        //File options
        MenuBar menu = new MenuBar();
        Menu fileMenu = new Menu("File");
        //account option
        MenuItem accountMenu = new MenuItem("Account");
        //TODO-> sends to account info pane

        //settings option
        MenuItem settingsMenu = new MenuItem("Settings");
        //TODO-> send to settings pane

        MenuItem exit = new MenuItem("Close Application");
        exit.setOnAction(e->{
            System.exit(0);
        });

        //credits
        Menu creditsMenu = new Menu("Credits");
        MenuItem ideUsed = new MenuItem("IDE: IntelliJ");
        MenuItem founderOne = new MenuItem("Ali Mehdi");
        MenuItem founderTwo = new MenuItem("Brock Whitson");
        //add credits to tab
        creditsMenu.getItems().addAll(founderOne,founderTwo, ideUsed);
        fileMenu.getItems().addAll(accountMenu, settingsMenu, exit);
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