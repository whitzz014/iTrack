package com.example.itrack.scenes;


import com.example.itrack.Constants.ScreenRatio;
import com.example.itrack.panes.SettingsPane;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SettingsScene extends Scene {
    /**
     * Creates a Scene for a specific root Node.
     *
     * @throws NullPointerException if root is null
     */
    public SettingsScene() {
        super(new SettingsPane(), ScreenRatio.SCREEN_WIDTH, ScreenRatio.SCREEN_HEIGHT);
    }
}
