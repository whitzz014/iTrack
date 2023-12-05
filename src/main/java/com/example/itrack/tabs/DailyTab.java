package com.example.itrack.tabs;


import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class DailyTab extends Tab {

    private static DailyTab instance;



    private DailyTab(){
        this.setText("Daily");
        GridPane root = new GridPane();
        this.setContent(root);
        getStyleClass().add("tab");

    }


    public static DailyTab getInstance(){
        if (instance == null){
            instance = new DailyTab();
        }
        return instance;
    }
}
