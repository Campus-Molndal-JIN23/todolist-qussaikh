package org.campusmolndal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TodoTest {

	@Test
	public void testGetId() {
		Todo todo = new Todo(1, "Task 1", "Description 1", false);
		assertEquals(1, todo.getId());
	}

	@Test
	public void testGetTitle() {
		Todo todo = new Todo(1, "Task 1", "Description 1", false);
		assertEquals("Task 1", todo.getTitle());
	}

	@Test
	public void testGetDescription() {
		Todo todo = new Todo(1, "Task 1", "Description 1", false);
		assertEquals("Description 1", todo.getDescription());
	}

	@Test
	public void testIsCompleted() {
		Todo todo = new Todo(1, "Task 1", "Description 1", false);
		assertFalse(todo.isCompleted());
	}

	@Test
	public void testSetTitle() {
		Todo todo = new Todo(1, "Task 1", "Description 1", false);
		todo.setTitle("Updated Title");
		assertEquals("Updated Title", todo.getTitle());
	}

	@Test
	public void testSetDescription() {
		Todo todo = new Todo(1, "Task 1", "Description 1", false);
		todo.setDescription("Updated Description");
		assertEquals("Updated Description", todo.getDescription());
	}

	@Test
	public void testSetCompleted() {
		Todo todo = new Todo(1, "Task 1", "Description 1", false);
		todo.setCompleted(true);
		assertTrue(todo.isCompleted());
	}
}
