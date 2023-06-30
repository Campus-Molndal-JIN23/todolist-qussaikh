package org.campusmolndal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TodoFacadeDBTest {
	private TodoFacadeDB todoFacade;

	@Mock
	private Database mockedDatabase;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		todoFacade = new TodoFacadeDB();
		todoFacade.database = mockedDatabase;
	}

	@Test
	public void testGetAllTodos() {
		// Skapa mockad lista av Todos
		List<Todo> todos = new ArrayList<>();
		todos.add(new Todo(1, "Todo 1", "Description 1", false));
		todos.add(new Todo(2, "Todo 2", "Description 2", true));

		// Definiera beteendet för getAllTodos-metoden
		when(mockedDatabase.getAllTodos()).thenReturn(todos);

		// Anropa metoden som ska testas
		List<Todo> result = todoFacade.getAllTodos();

		// Kontrollera att rätt lista av Todos returneras
		assertEquals(todos, result);
		verify(mockedDatabase).getAllTodos();
	}

	@Test
	public void testGetTodoById() {
		// Skapa en mockad Todo
		Todo todo = new Todo(1, "Todo 1", "Description 1", false);

		// Definiera beteendet för getTodoById-metoden
		when(mockedDatabase.getTodoById(1)).thenReturn(todo);

		// Anropa metoden som ska testas
		Todo result = todoFacade.getTodoById(1);

		// Kontrollera att rätt Todo returneras
		assertEquals(todo, result);
		verify(mockedDatabase).getTodoById(1);
	}

	@Test
	public void testAddOrUpdateTodo() {
		// Skapa en mockad Todo
		Todo todo = new Todo(1, "Todo 1", "Description 1", false);

		// Anropa metoden som ska testas
		todoFacade.updateTodo(1, "Todo 1 pro", "Description 1 pro", false);

		// Kontrollera att update-metoden anropas på rätt sätt
		verify(mockedDatabase).updateTodoInDatabase(1, "Todo 1 pro", "Description 1 pro", false);
	}

	@Test
	public void testDeleteTodoFromDatabase() {
		// Anropa metoden som ska testas
		todoFacade.deleteTodoFromDatabase(1);

		// Kontrollera att deleteTodoFromDatabase-metoden anropas på rätt sätt
		verify(mockedDatabase).deleteTodoFromDatabase(1);
	}
}
