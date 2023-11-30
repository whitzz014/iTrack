package com.example.itrack.scenes;

import com.example.itrack.Constants.ScreenRatio;
import com.example.itrack.MainApplication;
import com.example.itrack.panes.SignupPane;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SignupScene extends Scene {
    public SignupScene() {
        super(new SignupPane(), ScreenRatio.SCREEN_WIDTH,ScreenRatio.SCREEN_HEIGHT);
    }
}
