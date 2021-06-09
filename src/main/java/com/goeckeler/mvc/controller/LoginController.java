package com.goeckeler.mvc.controller;

import java.util.Optional;

import com.goeckeler.mvc.view.LoginView;
import com.goeckeler.mvc.model.User;
import com.goeckeler.mvc.model.Users;

public class LoginController
{

  final private LoginView view;
  final private Users model;

  public LoginController(final LoginView view, final Users model) {
    this.view = view;
    this.model = model;

    view.connectTo(this);
  }

  public void login(final String user, final String password) {
    StringBuilder error = new StringBuilder();

    if (user == null || user.isBlank()) {
      error.append("Benutzer muss eingegeben werden. ");
    }

    if (password == null || password.isBlank()) {
      error.append("Niemand kommt ohne Passwort hier rein. ");
    }

    if (error.length() > 0) {
      view.setMessage(error.toString());
      return;
    }

    Optional<User> match = model.match(new User(user, password));
    if (match.isPresent()) {
      view.welcome(match.get().toString());
      return;
    }
    view.setMessage(String.format("Der Benutzer '%s' hat keine Berechtigung oder das Passwort ist falsch.", user));
  }

  public void register(final String user, final String password) {
    view.setMessage("Das ist eine Demo, kein Wunschkonzert.");
  }
}
