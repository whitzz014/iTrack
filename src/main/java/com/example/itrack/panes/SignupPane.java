package com.example.itrack.panes;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.example.itrack.MainApplication.menu;

public class SignupPane extends BorderPane {
    public SignupPane() {
        this.setTop(menu);
        //Account Info
        //Title
        Text title = new Text("Account Info");
        Font titleFont = Font.font("Trebuchet MS", 18);
        title.setFont(titleFont);
        //Name
        Font textFont = Font.font("Trebuchet MS", 14);
        Text nameTitle = new Text("Name: ");
        nameTitle.setFont(textFont);
        //TODO-> Retrieve from SQL Table
        Text name = new Text();
        name.setFont(textFont);
        HBox nameBox = new HBox();
        nameBox.setAlignment(Pos.CENTER);
        nameBox.getChildren().addAll(nameTitle,name);

        //Vbox for all info
        VBox info = new VBox();
        info.setAlignment(Pos.CENTER);

        info.getChildren().addAll(title,nameBox);
        this.setCenter(info);
    }
}
