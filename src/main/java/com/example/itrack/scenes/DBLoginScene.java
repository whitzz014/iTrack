package com.example.itrack.scenes;

import com.example.itrack.Constants.ScreenRatio;
import com.example.itrack.panes.DBLoginPane;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class DBLoginScene extends Scene {
    /**
     * Creates a Scene for a specific root Node.
     *
     * @param root The root node of the scene graph
     * @throws NullPointerException if root is null
     */
    public DBLoginScene() {
        super(new DBLoginPane(), ScreenRatio.SCREEN_WIDTH, ScreenRatio.SCREEN_HEIGHT);
    }
}
