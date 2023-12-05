package com.example.itrack.panes;

import com.example.itrack.MainApplication;
import com.example.itrack.scenes.FormScene;
import com.example.itrack.scenes.SignupScene;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class DBLoginPane extends BorderPane {

    private final File personFile = new File("person_info.txt");

    /**
     * Creates a BorderPane layout.
     */
    public DBLoginPane() {
        BorderPane root = new BorderPane();
        File dbFile = new File("db_login.txt");
        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/com/example/itrack/iTrackLogo.png")));
        logo.setId("animLogo");

// Move onto the screen with a TranslateTransition
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), logo);
        translateTransition.setFromX(-200); // Set starting X position off-screen
        translateTransition.setToX(0); // Set ending X position on-screen


// SequentialTransition to combine both animations
        SequentialTransition sequentialTransition = new SequentialTransition(translateTransition);

// Play the combined animation
        sequentialTransition.play();


        setAlignment(logo, Pos.CENTER);

        VBox loginInput = new VBox(10);
        loginInput.setAlignment(Pos.CENTER); // Center the VBox

        // Set a common width for labels
        double labelWidth = 120;

        Text dbHost = new Text("Host: ");
        dbHost.setWrappingWidth(labelWidth);
        TextField host = createTextFieldWithMinWidth();
        HBox hostBox = new HBox();
        hostBox.setAlignment(Pos.CENTER); // Center the HBox
        hostBox.getChildren().addAll(dbHost, host);

        Text dbUsername = new Text("DB Username: ");
        dbUsername.setWrappingWidth(labelWidth);
        TextField username = createTextFieldWithMinWidth();
        HBox userBox = new HBox();
        userBox.setAlignment(Pos.CENTER); // Center the HBox
        userBox.getChildren().addAll(dbUsername, username);

        Text dbPass = new Text("DB Pass: ");
        dbPass.setWrappingWidth(labelWidth);
        TextField password = createTextFieldWithMinWidth();
        HBox passBox = new HBox();
        passBox.setAlignment(Pos.CENTER); // Center the HBox
        passBox.getChildren().addAll(dbPass, password);

        Text dbName = new Text("Db Name: ");
        dbName.setWrappingWidth(labelWidth);
        TextField name = createTextFieldWithMinWidth();
        HBox nameBox = new HBox();
        nameBox.setAlignment(Pos.CENTER); // Center the HBox
        nameBox.getChildren().addAll(dbName, name);



        Button signin = new Button("Sign in");



        signin.setOnAction(e -> {
            try (PrintWriter pr = new PrintWriter(dbFile)) {
                pr.println(host.getText());
                pr.println(username.getText());
                pr.println(password.getText());
                pr.println(name.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            Scene scene;
            if (personFile.length() == 0) {
                scene = new SignupScene();
            } else {
                scene = new FormScene();
            }
            MainApplication.mainStage.setScene(scene);
        });

        loginInput.getChildren().addAll(hostBox, userBox, passBox, nameBox, signin);


        setTop(logo);
        setCenter(loginInput);
        setAlignment(loginInput, Pos.CENTER); // Center the VBox within the BorderPane
        getStyleClass().add("root");
    }

    private TextField createTextFieldWithMinWidth() {
        TextField textField = new TextField();
        textField.setMinWidth(200); // Set a minimum width for consistency
        return textField;
    }
}
