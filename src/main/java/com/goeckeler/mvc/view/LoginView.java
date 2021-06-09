package com.goeckeler.mvc.view;

import com.goeckeler.mvc.controller.LoginController;
import com.goeckeler.mvc.model.SystemInfo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginView
{
  private LoginController controller;

  private GridPane pane;
  private Text feedback;

  public LoginView() {
    initPane();
  }

  public void setMessage(final String text) {
    feedback.setText(text == null ? "" : text);
  }

  public void welcome(final String name) {
    pane.getChildren().clear();

    Text title = new Text(String.format("Willkommen, %s!", name));
    title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 32));
    pane.add(title, 0, 0);

    Button ok = new Button("Okay");
    ButtonBar buttonBar = new ButtonBar();
    ButtonBar.setButtonData(ok, ButtonData.OK_DONE);
    buttonBar.getButtons().addAll(ok);

    pane.add(buttonBar, 0, 3);
    ok.setOnAction(event -> System.exit(0));
  }

  public Pane getPane() {
    return pane;
  }

  public String getTitle() {
    return "Model View Controller";
  }

  private Label versionLabel() {
    var javaVersion = SystemInfo.javaVersion();
    var javafxVersion = SystemInfo.javafxVersion();

    return new Label(String.format("JavaFX %s, running on Java %s.", javafxVersion, javaVersion));
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
    ButtonBar.setButtonData(login, ButtonData.OK_DONE);
    buttonBar.getButtons().addAll(login, register);
    pane.add(buttonBar, 1, 4);

    // feedback messages
    feedback = new Text();
    feedback.setFill(Color.FIREBRICK);
    feedback.setWrappingWidth(400);
    pane.add(feedback, 0, 6, 2, 2);

    // version info
    pane.add(versionLabel(), 0, 8, 2, 1);

    // actions
    register.setOnAction(event -> controller.register(user.getText(), password.getText()));
    login.setOnAction(event -> controller.login(user.getText(), password.getText()));
  }

  public void connectTo(final LoginController controller) {
    this.controller = controller;
  }
}
