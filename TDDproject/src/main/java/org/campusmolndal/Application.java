package org.campusmolndal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Application {
	 static Scanner scanner = new Scanner(System.in);
	 static TodoFacadeDB toDoFacadeDB = new TodoFacadeDB();
	 static UserfacadeDB userfacadeDB = new UserfacadeDB();
	 Database database = new Database();

	public void run() throws SQLException {
		 TodoFacadeDB toDoFacadeDB = new TodoFacadeDB();
		 UserfacadeDB userfacadeDB = new UserfacadeDB();
		toDoFacadeDB.connect("userTodo");
		userfacadeDB.connect("userTodo");
		toDoFacadeDB.createTodoTable();
		userfacadeDB.createUserTable();
		// lista
		boolean exit = false;
		while (!exit) {
			System.out.println("----- TODO App Menu -----");
			System.out.println("1. Create a new todo");
			System.out.println("2. View all todos");
			System.out.println("3. View a todo by ID");
			System.out.println("4. Update a todo");
			System.out.println("5. Delete a todo");
			System.out.println("6. Create a new user");
			System.out.println("7. View all users");
			System.out.println("8. View a user by ID");
			System.out.println("9. Update a user");
			System.out.println("10. Delete user");
			System.out.println("11. Exit");
			System.out.println("-------------------------");
			System.out.println("Enter your choice:");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline character

			switch (choice) {
				case 1:
					createNewTodo();
					break;
				case 2:
					viewAllTodos();
					break;
				case 3:
					viewTodoById();
					break;
				case 4:
					updateTodo();
					break;
				case 5:
					deleteTodo();
					break;
				case 6:
					createNewUser();
					break;
				case 7:
					viewAllUsers();
					break;
				case 8:
					viewUserById();
					break;
				case 9:
					updateUser();
					break;
				case 10:
					deleteUser();
					break;
				case 11:
					exit = true;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}

		//toDoFacadeDB.closeConnection();
		//userfacadeDB.closeConnection();
	}

	private static void createNewTodo() {
		System.out.println("Enter title:");
		String title = scanner.nextLine();
		System.out.println("Enter description:");
		String description = scanner.nextLine();
		System.out.println("Is completed? (true/false):");
		boolean completed = scanner.nextBoolean();

		Todo todo = new Todo(0, title, description, completed);
		toDoFacadeDB.addOrUpdateTodo(todo);
		System.out.println("Todo created successfully.");
	}

	private static void viewAllTodos() {
		System.out.println("----- All Todos -----");
		List<Todo> todos = toDoFacadeDB.getAllTodos();
		for (Todo todo : todos) {
			printTodoDetails(todo);
		}
		System.out.println("---------------------");
	}

	private static void viewTodoById() {
		System.out.println("Enter todo ID:");
		int id = scanner.nextInt();
		Todo todo = toDoFacadeDB.getTodoById(id);
		if (todo != null) {
			System.out.println("----- Todo Details -----");
			printTodoDetails(todo);
			System.out.println("------------------------");
		} else {
			System.out.println("Todo not found.");
		}
	}

	private static void updateTodo() {
		System.out.println("Enter todo ID:");
		int id = scanner.nextInt();
		//toDoFacadeDB.deleteTodoFromDatabase(id);
		scanner.nextLine();
		System.out.println("Enter title:");
		String title = scanner.nextLine();
		System.out.println("Enter description:");
		String description = scanner.nextLine();
		System.out.println("Is completed? (true/false):");
		boolean completed = scanner.nextBoolean();

		//Todo todo = new Todo(0, title, description, completed);
		toDoFacadeDB.updateTodo(id, title, description, completed);
		System.out.println("Todo updated successfully.");


//		System.out.println("Enter todo ID:");
//		int id = scanner.nextInt();
//		Todo todo = toDoFacadeDB.getTodoById(id);
//		if (todo != null) {
//			toDoFacadeDB.deleteTodoFromDatabase(id);
//			System.out.println("Enter new title (leave empty to keep current):");
//			String newTitle = scanner.nextLine();
//			System.out.println("Enter new description (leave empty to keep current):");
//			String newDescription = scanner.nextLine();
//			System.out.println("Is completed? (true/false):");
//			boolean newCompleted = scanner.nextBoolean();
//
//			if (!newTitle.isEmpty()) {
//				todo.setTitle(newTitle);
//			}
//			if (!newDescription.isEmpty()) {
//				todo.setDescription(newDescription);
//			}
//			todo.setCompleted(newCompleted);
//
//			toDoFacadeDB.updateTodo(id,newTitle,newDescription,newCompleted);
//			System.out.println("Todo updated successfully.");
//		} else {
//			System.out.println("Todo not found.");
//		}
	}

	private static void deleteTodo() {
		System.out.println("Enter todo ID:");
		int id = scanner.nextInt();
		toDoFacadeDB.deleteTodoFromDatabase(id);
		System.out.println("Todo deleted successfully.");
	}

	private static void createNewUser() {
		System.out.println("Enter user name:");
		String name = scanner.nextLine();

		User user = new User(0, name);
		userfacadeDB.addUser(user);
		System.out.println("User created successfully.");
	}

	private static void viewAllUsers() {
		System.out.println("----- All Users -----");
		List<User> users = userfacadeDB.getAllUsers();
		for (User user : users) {
			printUserDetails(user);
		}
		System.out.println("---------------------");
	}

	private static void viewUserById() {
		System.out.println("Enter user ID:");
		int id = scanner.nextInt();
		User user = userfacadeDB.getUserById(id);
		if (user != null) {
			System.out.println("----- User Details -----");
			printUserDetails(user);
			System.out.println("-----------------------");
		} else {
			System.out.println("User not found.");
		}
	}

	private static void updateUser() {
		System.out.println("Enter user ID:");
		int id = scanner.nextInt();
		//userfacadeDB.deleteUserFromDatabase(id);
		scanner.nextLine();
		System.out.println("Enter user name:");
		String name = scanner.nextLine();

		//User user = new User(0, name);
		userfacadeDB.updateUser(id,name);
		System.out.println("User updated successfully.");
//		System.out.println("Enter user ID:");
//		int id = scanner.nextInt();
//		scanner.nextLine(); // Consume newline character
//		userfacadeDB.deleteUserFromDatabase(id);
//		User user = userfacadeDB.getUserById(id);
//		if (user != null) {
//			System.out.println("Enter new name (leave empty to keep current):");
//			String newName = scanner.nextLine();
//
//			if (!newName.isEmpty()) {
//				user.setName(newName);
//			}
//
//			userfacadeDB.addUser(user);
//			System.out.println("User updated successfully.");
//		} else {
//			System.out.println("User not found.");
//		}
	}

	private static void deleteUser() {
		System.out.println("Enter user ID:");
		int id = scanner.nextInt();
		userfacadeDB.deleteUserFromDatabase(id);
		System.out.println("User deleted successfully.");
	}

	private static void printTodoDetails(Todo todo) {
		System.out.println("Todo ID: " + todo.getId());
		System.out.println("Title: " + todo.getTitle());
		System.out.println("Description: " + todo.getDescription());
		System.out.println("Completed: " + todo.isCompleted());
		System.out.println();
	}

	private static void printUserDetails(User user) {
		System.out.println("User ID: " + user.getId());
		System.out.println("Name: " + user.getName());
		System.out.println();
	}
}


