/**
 * Name: iTrack
 * created by: Brock Whitson and Ali Mehdi
 * description: Macro Nutrient tracker that can be set to help you reach the users goals.
 */
package com.example.itrack;


import com.example.itrack.scenes.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {


    //File options
    public static  MenuBar menu = new MenuBar();

    public static Stage mainStage;

    public static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {


        //credits
        Menu creditsMenu = new Menu("Credits");
        MenuItem ideUsed = new MenuItem("IDE: IntelliJ");
        MenuItem illustrator = new MenuItem("Adobe Illustrator");
        MenuItem founderOne = new MenuItem("Ali Mehdi");
        MenuItem founderTwo = new MenuItem("Brock Whitson");


        creditsMenu.getItems().addAll(founderOne,founderTwo, ideUsed);
        menu.getMenus().addAll( creditsMenu);




        File personFile = new File("person_info.txt");
        File dbFile = new File("db_login.txt");
/**
 * checks to see if file is empty
 * if it is empty it displays a pop window for the user to input info
 * when the signup button is clicked the users info is inputted to `person_info.txt`
 * If user is already filled out it is sends the user to tracker tab and displays all the info
// */

//cvcqqcvcqqxd66mxd66m


        if (dbFile.length() == 0){
            scene = new DBLoginScene();

        } else if (personFile.length() == 0){
            scene = new SignupScene();
        }else {
            scene = new FormScene();
        }

    //connect stage to mainStage
      mainStage = stage;
      //so user cant adjust application size
      mainStage.setResizable(false);
      mainStage.setTitle("iTrack");
        //connect FormScene so it is the main scene
      mainStage.setScene(scene);
      mainStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}