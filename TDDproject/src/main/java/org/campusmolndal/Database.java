package org.campusmolndal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Database {
	Connection connection;
	Statement statement;

	public void connect(String dbName) {
		try {
			// Ladda JDBC-drivrutinen för SQLite
			Class.forName("org.sqlite.JDBC");
			// Skapa en anslutning till databasen
			connection = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
			// Skapa ett Statement-objekt för att utföra SQL-frågor
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	 void createTablesIfNotExist() throws SQLException {
		String createTodoTableQuery = "CREATE TABLE IF NOT EXISTS todos (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT, completed BOOLEAN)";
		String createUserTableQuery = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
		Statement statement = connection.createStatement();
		statement.execute(createTodoTableQuery);
		statement.execute(createUserTableQuery);
	}

	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Todo> getAllTodos() {
		List<Todo> todos = new ArrayList<>();
		String query = "SELECT * FROM todos";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				boolean completed = resultSet.getBoolean("completed");
				Todo todo = new Todo(id, title, description, completed);
				todos.add(todo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return todos;
	}

	public Todo getTodoById(int id) {
		String query = "SELECT * FROM todos WHERE id = " + id;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				boolean completed = resultSet.getBoolean("completed");
				return new Todo(id, title, description, completed);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addOrUpdateTodo(Todo todo) {
		if (todo.getId() > 0) {
			updateTodoInDatabase(todo);
		} else {
			addTodoToDatabase(todo);
		}
	}

	public void addTodoToDatabase(Todo todo) {
		String query = "INSERT INTO todos (title, description, completed) VALUES (?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, todo.getTitle());
			statement.setString(2, todo.getDescription());
			statement.setBoolean(3, todo.isCompleted());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTodoInDatabase(Todo todo) {
		String query = "UPDATE todos SET title = ?, description = ?, completed = ? WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, todo.getTitle());
			statement.setString(2, todo.getDescription());
			statement.setBoolean(3, todo.isCompleted());
			statement.setInt(4, todo.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTodoFromDatabase(int id) {
		String query = "DELETE FROM todos WHERE id = " + id;
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM users";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				User user = new User(id, name);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User getUserById(int id) {
		String query = "SELECT * FROM users WHERE id = " + id;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				String name = resultSet.getString("name");
				return new User(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addOrUpdateUser(User user) {
		if (user.getId() > 0) {
			updateUserInDatabase(user);
		} else {
			addUserToDatabase(user);
		}
	}

	public void addUserToDatabase(User user) {
		String query = "INSERT INTO users (name) VALUES (?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getName());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUserInDatabase(User user) {
		String query = "UPDATE users SET name = ? WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getName());
			statement.setInt(2, user.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUserFromDatabase(int id) {
		String query = "DELETE FROM users WHERE id = " + id;
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

