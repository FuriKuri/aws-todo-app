package net.furikuri.domain;


public class Todo {
  private String id;
  private String value;

  public Todo(String id, String value) {
    this.id = id;
    this.value = value;
  }

  public Todo() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
