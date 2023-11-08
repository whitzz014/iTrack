package com.example.itrack.panes;

import javafx.geometry.Side;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.Region;
import javafx.scene.transform.Rotate;

public class CustomTabPane extends TabPane {

    public CustomTabPane() {
        // Call the super constructor
        super();

        // Set the side of the tab pane to BOTTOM
        setSide(Side.BOTTOM);
    }

    @Override
    protected void layoutChildren() {
        // Rotate the tabs 180 degrees (upwards) without affecting the content
        for (Tab tab : getTabs()) {
            Region header = (Region) tab.getGraphic();
            if (header != null) {
                Rotate rotate = new Rotate(180, header.getWidth() / 2, header.getHeight() / 2);
                header.getTransforms().setAll(rotate);
            }
        }

        super.layoutChildren();
    }
}
