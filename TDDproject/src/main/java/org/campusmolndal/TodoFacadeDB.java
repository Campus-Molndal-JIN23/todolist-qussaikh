package org.campusmolndal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TodoFacadeDB {
	 Database database = new Database();


	public void connect(String dbName) {
		database.connect(dbName);
	}
	public void createTable() throws SQLException {
		connect("userTodo");
		database.createTablesIfNotExist();
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
		database.addOrUpdateTodo(todo);
	}

	public void deleteTodoFromDatabase(int id) {
		connect("userTodo");
		database.deleteTodoFromDatabase(id);
	}

}

