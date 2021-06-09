package com.goeckeler.mvc;

import com.goeckeler.mvc.controller.LoginController;
import com.goeckeler.mvc.model.Users;
import com.goeckeler.mvc.view.LoginView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX MVC App
 */
public class App extends Application
{
    @Override
    public void start(final Stage stage) {
        LoginView view = new LoginView();
        var scene = new Scene(view.getPane(), 500, 300);
        stage.setScene(scene);
        stage.setTitle(view.getTitle());
        stage.show();

        Users model = new Users();
        new LoginController(view, model);
    }

    public static void main(String[] args) {
        launch();
    }
}
