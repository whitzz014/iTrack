package com.example.itrack.scenes;

import com.example.itrack.Constants.ScreenRatio;
import com.example.itrack.MainApplication;
import com.example.itrack.panes.SettingsPane;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AccountScene extends Scene {
    /**
     * Creates a Scene for a specific root Node.
     *h
     * @throws NullPointerException if root is null
     */
    public AccountScene() {
        super(new SettingsPane(), ScreenRatio.SCREEN_WIDTH, ScreenRatio.SCREEN_HEIGHT);
        MainApplication.mainStage.setTitle("Account");
    }
}
