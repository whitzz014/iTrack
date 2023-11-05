package com.example.itrack.panes;

import com.example.itrack.panes.CustomTabPane;
import com.example.itrack.tabs.DailyTab;
import com.example.itrack.tabs.WeeklyTab;
import javafx.scene.layout.BorderPane;

import static com.example.itrack.MainApplication.menu;

public class FormPane extends BorderPane {

    public FormPane() {
        // Custom tab pane
        CustomTabPane tabPane = new CustomTabPane();

        // Add tabs
        DailyTab dailyTab = DailyTab.getInstance();
        WeeklyTab weeklyTab = WeeklyTab.getInstance();
        dailyTab.setClosable(false);
        weeklyTab.setClosable(false);

        tabPane.getTabs().addAll(dailyTab, weeklyTab);

        // Add the custom tab pane to the bottom of the form pane
        this.setBottom(tabPane);

        // Add menu
        this.setTop(menu);
    }
}
