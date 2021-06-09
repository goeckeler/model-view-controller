package com.goeckeler.mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Group; 
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import com.goeckeler.mvc.model.SystemInfo;

public class View {
  private GridPane pane;

  public View() {
    initPane();
  }

  public Pane getPane() {
    return pane;
  }

  public String getTitle() {
      return "Model View Controller";
  }

  private void initPane() {
    pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setHgap(10);
    pane.setVgap(10);
    pane.setPadding(new Insets(25, 25, 25, 25));

    // headline
    Text title = new Text("Willkommen");
    title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    pane.add(title, 0, 0, 2, 1);

    // input
    Label userLabel = new Label("Benutzer:");
    pane.add(userLabel, 0, 1);
    
    TextField user = new TextField();
    pane.add(user, 1, 1);

    Label passwordLabel = new Label("Passwort:");
    pane.add(passwordLabel, 0, 2);

    PasswordField password = new PasswordField();
    pane.add(password, 1, 2);

    // buttons
    Button login = new Button("Anmelden");
    Button register = new Button("Registrieren");

    ButtonBar buttonBar = new ButtonBar();
    buttonBar.getButtons().addAll(login, register);
    pane.add(buttonBar, 1, 4);

    // feedback messages
    final Text feedback = new Text();
    pane.add(feedback, 0, 6, 2, 1);

    // version info
    pane.add(versionLabel(), 0, 8, 2, 1);
  }

  private Label versionLabel() {
    var javaVersion = SystemInfo.javaVersion();
    var javafxVersion = SystemInfo.javafxVersion();

    return new Label(String.format("JavaFX %s, running on Java %s.", javafxVersion, javaVersion));
  }
}
