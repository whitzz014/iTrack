package com.example.itrack.tabs;

import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class WeeklyTab extends Tab {

    private static WeeklyTab instance;



    private WeeklyTab(){
        this.setText("Weekly");
        GridPane root = new GridPane();
//        Image image = new Image("banana.jpeg");
//
//        // Create an ImageView to display the image
//        ImageView imageView = new ImageView(image);
//        root.getChildren().add(imageView);
        Text text = new Text();
        text.setText("hello world");
        root.add(text, 1, 1);
        this.setContent(root);
    }


    public static WeeklyTab getInstance(){
        if (instance == null){
            instance = new WeeklyTab();
        }
        return instance;
    }
}
