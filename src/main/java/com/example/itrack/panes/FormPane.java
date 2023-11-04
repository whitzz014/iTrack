package com.example.itrack.panes;

import com.example.itrack.tabs.TrackerTab;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class FormPane extends BorderPane {

    public FormPane(){
        //create tabPane
        TabPane tabPane = new TabPane();
        //Create the tabs

        //AddItemTab addItemTab = new AddItemTab();
        TrackerTab addItemTab = TrackerTab.getInstance();//replaced with singleton form so we dont have to create new objected we commented out above
        addItemTab.setClosable(false);


        tabPane.getTabs().addAll(addItemTab);

        this.setBottom(tabPane);

        //add menu bar
        //File options
        MenuBar menu = new MenuBar();
        Menu fileMenu = new Menu("File");
        //account option
        MenuItem accountMenu = new MenuItem("Account");
        //TODO-> sends to account info pane

        //settings option
        MenuItem settingsMenu = new MenuItem("Settings");
        //TODO-> send to settings pane

        MenuItem exit = new MenuItem("Close Application");
        exit.setOnAction(e->{
            System.exit(0);
        });

        //credits
        Menu creditsMenu = new Menu("Credits");
        MenuItem ideUsed = new MenuItem("IDE: IntelliJ");
        MenuItem founderOne = new MenuItem("Ali Mehdi");
        MenuItem founderTwo = new MenuItem("Brock Whitson");
        //add credits to tab
        creditsMenu.getItems().addAll(founderOne,founderTwo, ideUsed);
        fileMenu.getItems().addAll(accountMenu, settingsMenu, exit);
        menu.getMenus().addAll(fileMenu,creditsMenu);


        this.setTop(menu);
    }
}
