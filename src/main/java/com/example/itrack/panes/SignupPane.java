package com.example.itrack.panes;

import com.example.itrack.MainApplication;
import com.example.itrack.database.DBConst;
import com.example.itrack.scenes.FormScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.*;
import java.sql.*;

import static com.example.itrack.MainApplication.menu;
import static com.example.itrack.database.Const.*;

public class SignupPane extends BorderPane {

    public SignupPane() {
        this.setTop(menu);
        //Fonts
        Font textFont = Font.font("Trebuchet MS", 14);
        Font titleFont = Font.font("Trebuchet MS", 18);
        Font errorFont = new Font("Times New Roman", 12);

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
       // String personName = name.getText();
        //Age
        Text ageTitle = new Text("Age: ");
        ageTitle.setFont(textFont);

        TextField age = new TextField();
        age.setPromptText("21");
        age.setFont(textFont);
     //   String personAge = age.getText();
        //HBox for name
        HBox ageBox = new HBox();
        ageBox.setAlignment(Pos.CENTER);
        ageBox.getChildren().addAll(ageTitle,age);

        //GENDER
        Text genderTitle = new Text("Gender: ");
        genderTitle.setFont(textFont);
        ComboBox<String> gender = new ComboBox();
        gender.getItems().addAll("Male", "Female");

       // String personGender = gender.getValue();

        //HBox for name
        HBox genderBox = new HBox();
        genderBox.setAlignment(Pos.CENTER);
        genderBox.getChildren().addAll(genderTitle,gender);

        //HEIGHT
        Text heightTitle = new Text("Height: ");
        heightTitle.setFont(textFont);
        TextField height = new TextField();

        ComboBox heightMeasurementBox = new ComboBox();
        heightMeasurementBox.getItems().addAll("Centimeters", "Feet");
        heightMeasurementBox.setValue("Feet");


        //String userHeight = height.getText();

        //HBox for name
        HBox heightBox = new HBox();
        heightBox.setAlignment(Pos.CENTER);
        heightBox.getChildren().addAll(heightTitle,height,heightMeasurementBox);

        //WEIGHT
        Text weightTitle = new Text("Weight: ");
        weightTitle.setFont(textFont);
        TextField weight = new TextField();
        weight.setPromptText("83");
        weight.setFont(textFont);
        ComboBox weightComboBox = new ComboBox();
        weightComboBox.getItems().addAll("kg", "lbs");
        weightComboBox.setValue("lbs");
      //  int userWeight = Integer.parseInt(weight.getText());
        //HBox for name
        HBox weightBox = new HBox();
        weightBox.setAlignment(Pos.CENTER);
        weightBox.getChildren().addAll(weightTitle,weight,weightComboBox);

        //GOAL WEIGHT
        Text goalWeightTitle = new Text("Goal Weight: ");
        goalWeightTitle.setFont(textFont);
        TextField goalWeight = new TextField();
        goalWeight.setPromptText("102");
        goalWeight.setFont(textFont);
        ComboBox gWeightComboBox = new ComboBox();
        gWeightComboBox.getItems().addAll("kg", "lbs");
        gWeightComboBox.setValue("lbs");
        // String userGoal = goalWeight.getText();

        //HBox for name
        HBox goalWeightBox = new HBox();
        goalWeightBox.setAlignment(Pos.CENTER);
        goalWeightBox.getChildren().addAll(goalWeightTitle,goalWeight,gWeightComboBox);

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
                measurementFile.println(weightComboBox.getValue());
                measurementFile.println(heightMeasurementBox.getValue());
                measurementFile.close();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }


            MainApplication.mainStage.setScene(new FormScene());
        });

        //VBox for info
        VBox signUpBox = new VBox();
        signUpBox.setAlignment(Pos.CENTER);
        signUpBox.getChildren().addAll(title,nameBox,ageBox, genderBox, heightBox,weightBox,goalWeightBox,activeBox,signupButton);

        this.setCenter(signUpBox);


    }

}
