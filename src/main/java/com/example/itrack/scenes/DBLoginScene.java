package com.example.itrack.scenes;

import com.example.itrack.Constants.ScreenRatio;
import com.example.itrack.panes.DBLoginPane;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class DBLoginScene extends Scene {
    /**
     * Creates a Scene for a specific root Node.
     *
     * @throws NullPointerException if root is null
     */
    public DBLoginScene() {
        super(new DBLoginPane(), ScreenRatio.SCREEN_WIDTH, ScreenRatio.SCREEN_HEIGHT);
        this.getStylesheets().add(getClass().getResource("/com/example/itrack/styles.css").toExternalForm());

    }
}
