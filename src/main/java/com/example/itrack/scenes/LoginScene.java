package com.example.itrack.scenes;

import com.example.itrack.Constants.ScreenRatio;
import com.example.itrack.MainApplication;
import com.example.itrack.panes.FormPane;
import com.example.itrack.panes.LoginPane;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginScene extends Scene {

    public LoginScene() {super(new LoginPane(), ScreenRatio.SCREEN_WIDTH, ScreenRatio.SCREEN_HEIGHT);
        MainApplication.mainStage.setTitle("Login");
    }
}
