package com.example.itrack.panes;

import com.example.itrack.MainApplication;
import com.example.itrack.database.DBConst;
import com.example.itrack.scenes.FormScene;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.sql.*;

import static com.example.itrack.MainApplication.menu;
import static com.example.itrack.database.Const.*;

public class AccountPane extends BorderPane {
    public AccountPane(){
        //Vbox
        VBox info = new VBox();
        info.setAlignment(Pos.CENTER);
        //FONT
        Font titleFont = Font.font("Trebuchet MS", 18);
        Font textFont = Font.font("Trebuchet MS", 14);
        //connects to database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/"+ DB_NAME +
                        "?serverTimezone=UTC",
                DB_USER,
                DB_PASS);){
            //query to pull from table so it can appear in pane
            String selectQuery = "SELECT * FROM " + DBConst.TABLE_PERSON_INFO;
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //Retrieves info from personal_info table
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                int height = resultSet.getInt("height");
                int weight = resultSet.getInt("weight");
                int goalWeight = resultSet.getInt("goalWeight");
                String gender = resultSet.getString("gender");

                //Title
                Text title = new Text("Account Info");
                title.setFont(titleFont);

                //Name
                Text nameTitle = new Text("Name: ");
                nameTitle.setFont(textFont);
                Text nameText = new Text(name);
                nameText.setFont(textFont);
                HBox nameBox = new HBox();
                nameBox.setAlignment(Pos.CENTER);
                nameBox.getChildren().addAll(nameTitle,nameText);

                //age
                Text ageTitle = new Text("Age: ");
                ageTitle.setFont(textFont);
                Text ageText = new Text(String.valueOf(age));
                ageText.setFont(textFont);
                HBox ageBox = new HBox();
                ageBox.setAlignment(Pos.CENTER);
                ageBox.getChildren().addAll(ageTitle,ageText);

                //gender
                Text genderTitle = new Text("Gender: ");
                genderTitle.setFont(textFont);
                Text genderText = new Text(gender);
                genderText.setFont(textFont);
                HBox genderBox = new HBox();
                genderBox.setAlignment(Pos.CENTER);
                genderBox.getChildren().addAll(genderTitle,genderText);

                //height
                Text heightTitle = new Text("Height: ");
                heightTitle.setFont(textFont);
                Text heightText = new Text(String.valueOf(height));
                heightText.setFont(textFont);
                HBox heightBox = new HBox();
                heightBox.setAlignment(Pos.CENTER);
                heightBox.getChildren().addAll(heightTitle,heightText);

                //height
                Text weightTitle = new Text("Weight: ");
                weightTitle.setFont(textFont);
                Text weightText = new Text(String.valueOf(weight));
                weightText.setFont(textFont);
                HBox weightBox = new HBox();
                weightBox.setAlignment(Pos.CENTER);
                weightBox.getChildren().addAll(weightTitle,weightText);

                //height
                Text goalWeightTitle = new Text("Height: ");
                goalWeightTitle.setFont(textFont);
                Text goalWeightText = new Text(String.valueOf(goalWeight));
                goalWeightText.setFont(textFont);
                HBox goalWeightBox = new HBox();
                goalWeightBox.setAlignment(Pos.CENTER);
                goalWeightBox.getChildren().addAll(goalWeightTitle,goalWeightText);

                //Vbox for all info
                info.getChildren().addAll(title,nameBox,ageBox,genderBox,heightBox,weightBox,goalWeightBox);
            }

        }catch (SQLException ev){
            ev.printStackTrace();
        }
        this.setTop(menu);
        this.setCenter(info);
    }
}
