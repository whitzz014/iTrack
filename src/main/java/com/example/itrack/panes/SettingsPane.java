package com.example.itrack.panes;

import javafx.scene.layout.BorderPane;

import static com.example.itrack.MainApplication.*;

/**
 * Created by: Brock Whitson
 * Date: 2023-11-03
 * Desc: iTracks settings page so the user can adjust things like height from ft->cm or lbs->kg
 */
public class SettingsPane extends BorderPane {

    public SettingsPane(){
        //add menu
        this.setTop(menu) ;
}
}
