package com.goeckeler.mvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.goeckeler.mvc.model.Credentials;
import com.goeckeler.mvc.view.View;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        View view = new View();
        var scene = new Scene(view.getPane(), 400, 300);
        stage.setScene(scene);
        stage.setTitle(view.getTitle());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}