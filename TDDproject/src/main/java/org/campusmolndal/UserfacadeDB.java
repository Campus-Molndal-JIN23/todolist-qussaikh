package org.campusmolndal;

import java.sql.SQLException;
import java.util.List;

public class UserfacadeDB {
	  Database database = new Database();

	public void connect(String dbName) {
		database.connect(dbName);
	}
	public void createUserTable() throws SQLException {
		connect("userTodo");
		database.createUserTablesIfNotExist();
	}
	public void closeConnection() {
		database.closeConnection();
	}

	public List<User> getAllUsers() {
		connect("userTodo");
		return database.getAllUsers();
	}

	public User getUserById(int id) {
		connect("userTodo");
		return database.getUserById(id);
	}

	public void addUser(User user) {
		connect("userTodo");
		database.addUserToDatabase(user);
	}
	public void updateUser(int id, String name) {
		connect("userTodo");
		database.updateUserInDatabase(id,name);
	}



	public void deleteUserFromDatabase(int id) {
		connect("userTodo");
		database.deleteUserFromDatabase(id);

	}
}

