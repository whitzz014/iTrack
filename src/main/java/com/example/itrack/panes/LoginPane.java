package com.example.itrack.panes;

import com.example.itrack.MainApplication;
import com.example.itrack.database.DBConst;
import com.example.itrack.scenes.FormScene;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.sql.*;

import static com.example.itrack.MainApplication.menu;
import static com.example.itrack.database.Const.*;

public class LoginPane extends BorderPane {
    TextField username = new TextField();
    TextField password = new TextField();


    public LoginPane() {
        //Font
        Font errorFont = new Font("Times New Roman", 12);

        this.setTop(menu);



//
//        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/resources/iTrackLogo.png")));
//
//        logo.setPreserveRatio(true);


        //hbox for alignment of username
        HBox userNameBox = new HBox();
        Text usernameText = new Text("Username: ");
        username.setPromptText("username");
        userNameBox.setAlignment(Pos.CENTER);
        userNameBox.getChildren().addAll(usernameText, username);
        //hbox for password
        HBox passwordBox = new HBox();
        Text passwordText = new Text("Password: ");
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

        loginButton.setOnAction(e->{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME +
                            "?serverTimezone=UTC",
                    DB_USER,
                    DB_PASS);) {
                String loginVerify = "SELECT username FROM " + DBConst.TABLE_ACCOUNT_INFO
                        + " WHERE username = ? AND password =?";
                PreparedStatement loginStatement = connection.prepareStatement(loginVerify);
                loginStatement.setString(1, username.getText());
                loginStatement.setString(2, password.getText());
                ResultSet resultSet = loginStatement.executeQuery();
                if (resultSet.next()){
                    MainApplication.mainStage.setScene(new FormScene());
                }else{
                    Text invalid = new Text("Invalid username/password");
                    centerLogin.getChildren().add(invalid);
                    invalid.setStyle("-fx-prompt-text-fill: red;");
                    invalid.setFont(errorFont);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }
}
