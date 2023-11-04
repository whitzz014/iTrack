package com.example.itrack.panes;
import com.example.itrack.tabs.TrackerTab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

import static com.example.itrack.MainApplication.*;

public class FormPane extends BorderPane {

    public FormPane(){

        //tab pane
         TabPane tabPane = new TabPane();
        //add tabs
        TrackerTab addItemTab = TrackerTab.getInstance();//replaced with singleton form so we don't have to create new objected we commented out above
        //AddItemTab addItemTab = new AddItemTab();
        addItemTab.setClosable(false);
        tabPane.getTabs().addAll(addItemTab);
        this.setBottom(tabPane);
        //add menu
        this.setTop(menu);
    }
}
