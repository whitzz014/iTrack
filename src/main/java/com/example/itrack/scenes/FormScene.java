package com.example.itrack.scenes;

import com.example.itrack.Constants.ScreenRatio;
import com.example.itrack.MainApplication;
import com.example.itrack.panes.FormPane;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 */
public class FormScene extends Scene {
    /**
     * Creates a Scene for a specific root Node.
     *
     * @param root The root node of the scene graph
     * @throws NullPointerException if root is null
     */
    public FormScene() {
        super(new FormPane(), ScreenRatio.SCREEN_WIDTH, ScreenRatio.SCREEN_HEIGHT);
        MainApplication.mainStage.setTitle("Tracker");

    }
}
