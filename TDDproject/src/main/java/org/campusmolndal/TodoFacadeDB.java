package org.campusmolndal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TodoFacadeDB {
	 Database database = new Database();
	 private String dbName = "table1";


	public void connect(String dbName) {
		database.connect(dbName);
	}
	public void createTodoTable() throws SQLException {
		connect("userTodo");
		database.createTodoTablesIfNotExist();
	}
	public void closeConnection() {
		database.closeConnection();
	}

	public List<Todo> getAllTodos() {
		connect("userTodo");
		return database.getAllTodos();
	}

	public Todo getTodoById(int id) {
		connect("userTodo");
		return database.getTodoById(id);
	}

	public void addOrUpdateTodo(Todo todo) {
		connect("userTodo");
		database.addTodoToDatabase(todo);
	}

	public void updateTodo(int id, String title, String description, boolean completed) {
		connect("userTodo");
		database.updateTodoInDatabase(id,title,description,completed);
	}



	public void deleteTodoFromDatabase(int id) {
		connect("userTodo");
		database.deleteTodoFromDatabase(id);
	}

}

