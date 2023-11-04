/**
 * Name: iTrack
 * created by: Brock Whitson and Ali Mehdi
 * description: Macro Nutrient tracker that can be set to help you reach the users goals.
 */
package com.example.itrack;


import com.example.itrack.scenes.FormScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        //Mayo De Noche
    //connect stage to mainstage
      mainStage = stage;
      //so user cant adjust application size
      mainStage.setResizable(false);
      //app title
      mainStage.setTitle("iTrack");
      //connect FormScene so it is the main scene
      mainStage.setScene(new FormScene());
      mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}