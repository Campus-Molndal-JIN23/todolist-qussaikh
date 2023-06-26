package org.campusmolndal;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.List;
public class DatabaseTest {
	private Connection connection;
	private Database database;

	@BeforeEach
	public void setup() {
		try {
			// Skapa en anslutning till den in-memory SQLite-databasen
			connection = DriverManager.getConnection("jdbc:sqlite::memory:");

			// Skapa tabellen "todos" i databasen
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE TABLE todos (id INTEGER PRIMARY KEY, title TEXT, description TEXT, completed INTEGER)");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");

			// Skapa en TodoDao med den skapade anslutningen
			database = new Database();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTodoCRUD() throws SQLException {
		// Skapa en ny Todo
		Todo todo = new Todo(1, "Todo 1", "Description 1", false);

		// Anslut till databasen
		database.connect("todoTest");
		database.createTablesIfNotExist();

		// Lägg till Todo i databasen
		database.addTodoToDatabase(todo);

		// Hämta alla Todos från databasen
		List<Todo> todos = database.getAllTodos();
		assertEquals(1, todos.size());

		// Uppdatera Todo
		todo.setTitle("Updated Title");
		database.updateTodoInDatabase(todo);

		// Hämta uppdaterad Todo från databasen
		Todo updatedTodo = database.getTodoById(1);
		assertEquals("Updated Title", updatedTodo.getTitle());

		// Ta bort Todo från databasen
		database.deleteTodoFromDatabase(1);

		// Kontrollera att Todo har tagits bort
		Todo deletedTodo = database.getTodoById(1);
		assertNull(deletedTodo);
	}

	@Test
	public void testUserCRUD() throws SQLException {
		// Skapa en ny User
		User user = new User(1, "User 1");

		database.connect("userTest");
		database.createTablesIfNotExist();

		// Lägg till User i databasen
		database.addUserToDatabase(user);

		// Hämta alla Users från databasen
		List<User> users = database.getAllUsers();
		assertEquals(1, users.size());

		// Uppdatera User
		user.setName("Updated user");
		database.updateUserInDatabase(user);

		// Hämta uppdaterad User från databasen
		User updatedUser = database.getUserById(1);
		assertEquals("Updated user", updatedUser.getName());

		// Ta bort User från databasen
		database.deleteUserFromDatabase(1);

		// Kontrollera att User har tagits bort
		User deletedUser = database.getUserById(1);
		assertNull(deletedUser);
	}

}