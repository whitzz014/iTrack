package com.example.itrack.panes;

import com.example.itrack.MainApplication;
import com.example.itrack.scenes.LoginScene;
import com.example.itrack.scenes.SignupScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.example.itrack.MainApplication.menu;

public class SignupPane extends BorderPane {
    public SignupPane() {
        this.setTop(menu);
        //Fonts
        Font textFont = Font.font("Trebuchet MS", 14);
        Font titleFont = Font.font("Trebuchet MS", 18);

        //Sign Up
        //Title
        Text title = new Text("Sign Up");
        title.setFont(titleFont);

        //USERNAME
        Text usernameTitle = new Text("Username: ");
        usernameTitle.setFont(textFont);

        TextField username = new TextField();
        username.setPromptText("Whitzz14");
        username.setFont(textFont);

        //HBox -- username
        HBox usernameBox = new HBox();
        usernameBox.setAlignment(Pos.CENTER);
        usernameBox.getChildren().addAll(usernameTitle,username);

        //PASSWORD
        Text passTitle = new Text("Password: ");
        passTitle.setFont(textFont);

        TextField password = new TextField();
        password.setPromptText("********");
        password.setFont(textFont);

        //HBox -- username
        HBox passBox = new HBox();
        passBox.setAlignment(Pos.CENTER);
        passBox.getChildren().addAll(passTitle,password);

        //Name
        Text nameTitle = new Text("Name: ");
        nameTitle.setFont(textFont);

        TextField name = new TextField();
        name.setPromptText("Brock Whitson");
        name.setFont(textFont);

        //HBox for name
        HBox nameBox = new HBox();
        nameBox.setAlignment(Pos.CENTER);
        nameBox.getChildren().addAll(nameTitle,name);

        //Age
        Text ageTitle = new Text("Age: ");
        ageTitle.setFont(textFont);

        TextField age = new TextField();
        age.setPromptText("21");
        age.setFont(textFont);

        //HBox for name
        HBox ageBox = new HBox();
        ageBox.setAlignment(Pos.CENTER);
        ageBox.getChildren().addAll(ageTitle,age);

        //GENDER
        Text genderTitle = new Text("Gender: ");
        genderTitle.setFont(textFont);
        ComboBox<String> gender = new ComboBox();
        gender.getItems().addAll("Male", "Female");

        //HBox for name
        HBox genderBox = new HBox();
        genderBox.setAlignment(Pos.CENTER);
        genderBox.getChildren().addAll(genderTitle,gender);

        //HEIGHT
        Text heightTitle = new Text("Height: ");
        heightTitle.setFont(textFont);
        TextField height = new TextField();
        height.setPromptText("190cm");
        height.setFont(textFont);

        //HBox for name
        HBox heightBox = new HBox();
        heightBox.setAlignment(Pos.CENTER);
        heightBox.getChildren().addAll(heightTitle,height);

        //WEIGHT
        Text weightTitle = new Text("Weight: ");
        weightTitle.setFont(textFont);
        TextField weight = new TextField();
        weight.setPromptText("83kg");
        weight.setFont(textFont);

        //HBox for name
        HBox weightBox = new HBox();
        weightBox.setAlignment(Pos.CENTER);
        weightBox.getChildren().addAll(weightTitle,weight);

        //GOAL WEIGHT
        Text goalWeightTitle = new Text("Goal Weight: ");
        goalWeightTitle.setFont(textFont);
        TextField goalWeight = new TextField();
        goalWeight.setPromptText("102 kg");
        goalWeight.setFont(textFont);

        //HBox for name
        HBox goalWeightBox = new HBox();
        goalWeightBox.setAlignment(Pos.CENTER);
        goalWeightBox.getChildren().addAll(goalWeightTitle,goalWeight);

        //Button
        Button signupButton = new Button("Sign Up");
        signupButton.setOnAction(e->{
            
            MainApplication.mainStage.setScene(new LoginScene());
        });

        //VBox for info
        VBox signUpBox = new VBox();
        signUpBox.setAlignment(Pos.CENTER);
        signUpBox.getChildren().addAll(title,usernameBox, passBox, nameBox,ageBox, genderBox, heightBox,weightBox,goalWeightBox, signupButton);

        this.setCenter(signUpBox);
    }
}
