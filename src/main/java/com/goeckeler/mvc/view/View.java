package com.goeckeler.mvc.view;

import javafx.scene.Group; 
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import com.goeckeler.mvc.model.SystemInfo;

public class View extends Group {

  public View() {
    super();
    this.getChildren().add(new StackPane(versionLabel()));
  }

  private Label versionLabel() {
    var javaVersion = SystemInfo.javaVersion();
    var javafxVersion = SystemInfo.javafxVersion();

    return new Label(String.format("JavaFX %s, running on Java %s.", javafxVersion, javaVersion));
  }
}
