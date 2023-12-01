package com.example.itrack.tabs;


import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class MealsTab extends Tab {

    private static MealsTab instance;



    private MealsTab(){
        this.setText("Tracker");
        GridPane root = new GridPane();
        this.setContent(root);
    }


    public static MealsTab getInstance(){
        if (instance == null){
            instance = new MealsTab();
        }
        return instance;
    }
}
