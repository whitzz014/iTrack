package com.example.itrack.tabs;


import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class TrackerTab extends Tab {

    private static TrackerTab instance;



    private TrackerTab(){
        this.setText("Add Item");
        GridPane root = new GridPane();
        this.setContent(root);
        getStyleClass().add("tab");

    }


    public static TrackerTab getInstance(){
        if (instance == null){
            instance = new TrackerTab();
        }
        return instance;
    }
}
