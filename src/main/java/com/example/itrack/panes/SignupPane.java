package com.example.itrack.panes;

import com.example.itrack.MainApplication;
import com.example.itrack.database.DBConst;
import com.example.itrack.scenes.FormScene;
import com.example.itrack.scenes.SignupScene;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.*;
import java.sql.*;

import static com.example.itrack.MainApplication.mainStage;
import static com.example.itrack.MainApplication.menu;
import static com.example.itrack.database.Const.*;

public class SignupPane extends BorderPane {

private String userHeight;
private String userWeight;
    public SignupPane() {
        this.setTop(menu);
        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/com/example/itrack/iTrackLogo.png")));

        //Fonts
        Font textFont = Font.font("Trebuchet MS", 14);
        Font titleFont = Font.font("Trebuchet MS", 18);


        //Sign Up
        //Title
        Text title = new Text("Sign Up");
        title.setFont(titleFont);


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
        height.setPromptText("6.02");
        RadioButton heightFeet = new RadioButton("Feet");
        heightFeet.setSelected(true);
        RadioButton heightCm = new RadioButton("cm");

        // ToggleGroup for height radio buttons
        ToggleGroup heightToggleGroup = new ToggleGroup();
        heightFeet.setToggleGroup(heightToggleGroup);
        heightCm.setToggleGroup(heightToggleGroup);





        //HBox for name
        HBox heightBox = new HBox();
        heightBox.setAlignment(Pos.CENTER);
        heightBox.getChildren().addAll(heightTitle,height,heightFeet, heightCm);

        //WEIGHT
        Text weightTitle = new Text("Weight: ");
        weightTitle.setFont(textFont);
        TextField weight = new TextField();
        weight.setPromptText("185");
        weight.setFont(textFont);
        RadioButton weightRbLbs = new RadioButton("lbs");
        weightRbLbs.setSelected(true);
        RadioButton weightRbKg = new RadioButton("kg");

        ToggleGroup weightToggleGroup = new ToggleGroup();
        weightRbLbs.setToggleGroup(weightToggleGroup);
        weightRbKg.setToggleGroup(weightToggleGroup);

        //HBox for name
        HBox weightBox = new HBox();
        weightBox.setAlignment(Pos.CENTER);
        weightBox.getChildren().addAll(weightTitle,weight,weightRbLbs,weightRbKg);

        //GOAL WEIGHT
        Text goalWeightTitle = new Text("Goal Weight: ");
        goalWeightTitle.setFont(textFont);
        TextField goalWeight = new TextField();
        goalWeight.setPromptText("215");
        goalWeight.setFont(textFont);
        RadioButton goalWeightLBS = new RadioButton("lbs");
        goalWeightLBS.setSelected(true);
        RadioButton goalWeightKG = new RadioButton("kg");

        //HBox for name
        HBox goalWeightBox = new HBox();
        goalWeightBox.setAlignment(Pos.CENTER);
        goalWeightBox.getChildren().addAll(goalWeightTitle,goalWeight,goalWeightLBS,goalWeightKG);

        Text activityText = new Text("Activity Level: ");
        activityText.setFont(textFont);
        ComboBox activityLevel = new ComboBox();
        activityLevel.getItems().addAll("Sedentary (little or no exercise)", "Lightly active (light exercise/sports 1-3 days/week)"
        , "Moderately active (moderate exercise/sports 3-5 days/week)", "Very active (hard exercise/sports 6-7 days a week)", "Extremely active (very hard exercise/sports & physical job or 2x training)");

        //Hbox for activity level
        HBox activeBox = new HBox();
        activeBox.setAlignment(Pos.CENTER);
        activeBox.getChildren().addAll(activityText, activityLevel);

        //Button
        Button signupButton = new Button("Enter");
        File file = new File("person_info.txt");


        signupButton.setOnAction(e-> {
            try {
                PrintWriter signup = new PrintWriter("person_info.txt");
                signup.println(name.getText());
                signup.println(age.getText());
                signup.println(gender.getValue());
                signup.println(height.getText());
                signup.println(weight.getText());
                signup.println(goalWeight.getText());
                signup.println(activityLevel.getValue());
                signup.close();
            } catch (IOException ex) {
                System.err.println("Error writing to " + file.getName() + ": " + ex.getMessage());
            }

            try {
                PrintWriter measurementFile = new PrintWriter("measurements.txt");
                measurementFile.println(((RadioButton) weightToggleGroup.getSelectedToggle()).getText());
                measurementFile.println(((RadioButton) heightToggleGroup.getSelectedToggle()).getText());
                measurementFile.close();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }

            MainApplication.mainStage.setScene(new FormScene());

        });

        signupButton.getStyleClass().add("add-button");

        //VBox for info
        VBox signUpBox = new VBox();
        signUpBox.setAlignment(Pos.CENTER);
        signUpBox.getChildren().addAll(logo,title,nameBox,ageBox, genderBox, heightBox,weightBox,goalWeightBox,activeBox,signupButton);

        getStyleClass().add("root");
        this.setCenter(signUpBox);


    }

}
