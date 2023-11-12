package com.example.itrack.panes;

import com.example.itrack.MainApplication;
import com.example.itrack.scenes.SignupScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import static com.example.itrack.MainApplication.menu;

public class LoginPane extends BorderPane {
    public LoginPane() {
        this.setTop(menu);
       // ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("iTrackLogo.png")));
        //hbox for alignment of username
        HBox userNameBox = new HBox();
        Text usernameText = new Text("Username: ");
        TextField username = new TextField();
        username.setPromptText("username");
        userNameBox.setAlignment(Pos.CENTER);
        userNameBox.getChildren().addAll(usernameText, username);
        //hbox for password
        HBox passwordBox = new HBox();
        Text passwordText = new Text("Password: ");
        TextField password = new TextField();
        password.setPromptText("password");
        passwordBox.setAlignment(Pos.CENTER);
        passwordBox.getChildren().addAll(passwordText, password);

        //Buttons
        Button signupButton = new Button("Sign Up");
        signupButton.setOnAction(e->{
            MainApplication.mainStage.setScene(new SignupScene());
        });

        Button loginButton = new Button("Login");

        //Button Hbox
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(loginButton, signupButton);
        Insets buttonPadding = new Insets(10, 20, 10, 20); // top, right, bottom, left
        buttons.setPadding(buttonPadding);

        //vbox for all inputs
        VBox centerLogin = new VBox();
        centerLogin.setAlignment(Pos.CENTER);
        centerLogin.getChildren().addAll(userNameBox, passwordBox, buttons);
        this.setCenter(centerLogin);
    }
}
