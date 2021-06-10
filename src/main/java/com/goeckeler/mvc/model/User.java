package com.goeckeler.mvc.model;

public class User
{
  private String user;
  private String password;
  private String name;

  public User() {
    this("", "geheim");
  }

  public User(String user, String password) {
    this(user, password, "Unbekannt");
  }

  public User(String user, String password, String name) {
    this.user = user;
    this.password = password;
    this.name = name;
  }

  @Override
  public String toString() {
    return (name == null ? "(n/a)" : name);
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null) return false;
    if (this == other) return true;

    if (other instanceof User) {
      User that = (User) other;
      return this.user.equalsIgnoreCase(that.user) && this.password.equals(that.password);
    }

    return false;
  }

  @Override
  public int hashCode() {
    return user.hashCode();
  }
}
