package models;

import java.util.ArrayList;

public class User {
    private String username;
    private ArrayList<Todo> todoList;

    public User(String username) {
        this.username = username;
        todoList = new ArrayList<Todo>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(ArrayList<Todo> todoList) {
        this.todoList = todoList;
    }

    public void addTodo(int id, String todo) {
        todoList.add(new Todo(id, todo));
    }

    public void addTodo(Todo todo) {
        todoList.add(todo);
    }

    public void removeTodo(Todo todo) {
        todoList.remove(todo);
    }
}
