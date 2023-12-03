package com.example.itrack.panes;

import com.example.itrack.MainApplication;
import com.example.itrack.scenes.DBLoginScene;
import com.example.itrack.scenes.FormScene;
import com.example.itrack.scenes.SignupScene;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URI;
import java.net.URL;

public class DBLoginPane extends BorderPane {

    private final File personFile = new File("person_info.txt");
    /**
     * Creates a BorderPane layout.
     */

    public DBLoginPane() {
        File dbFile = new File("db_login.txt");

       ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/com/example/itrack/iTrackLogo.png")));
        setAlignment(logo, Pos.CENTER);

        VBox loginInput = new VBox();

        Text dbHost = new Text("Host: ");
        TextField host = new TextField();
        HBox hostBox = new HBox();
        hostBox.getChildren().addAll(dbHost, host);

        Text dbUsername = new Text("DB Username: ");
        TextField username = new TextField();
        HBox userBox = new HBox();
        userBox.getChildren().addAll(dbUsername, username);

        Text dbPass = new Text("DB Pass: ");
        TextField password = new TextField();
        HBox passBox = new HBox();
        passBox.getChildren().addAll(dbPass, password);

        Text dbName = new Text("Db Name: ");
        TextField name = new TextField();
        HBox nameBox = new HBox();
        nameBox.getChildren().addAll(dbName,name);

        Button signin = new Button("Sign in");
        signin.setOnAction(e->{
            try (PrintWriter pr = new PrintWriter(dbFile)){
                pr.println(host.getText());
                pr.println(username.getText());
                pr.println(password.getText());
                pr.println(name.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

           Scene scene;
            if (personFile.length() == 0){
                scene = new SignupScene();
            }else{
                scene = new FormScene();
            }

            MainApplication.mainStage.setScene(scene);
        });

        loginInput.getChildren().addAll(hostBox, userBox, passBox, nameBox, signin);

        setTop(logo);
        setCenter(loginInput);




    }
}
