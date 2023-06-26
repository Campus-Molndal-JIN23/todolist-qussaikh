package org.campusmolndal;

import java.sql.SQLException;
import java.util.List;

public class UserfacadeDB {
	  Database database = new Database();

	public void connect(String dbName) {
		database.connect(dbName);
	}
	public void createTable() throws SQLException {
		connect("userTodo");
		database.createTablesIfNotExist();
	}

	public List<User> getAllUsers() {
		connect("userTodo");
		return database.getAllUsers();
	}

	public User getUserById(int id) {
		connect("userTodo");
		return database.getUserById(id);
	}

	public void addOrUpdateUser(User user) {
		connect("userTodo");
		database.addOrUpdateUser(user);
	}

	public void deleteUserFromDatabase(int id) {
		connect("userTodo");
		database.deleteUserFromDatabase(id);

	}
}

