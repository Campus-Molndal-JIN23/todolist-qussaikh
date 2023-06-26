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

public class UserFacadeDBTest {
	private UserfacadeDB userFacade;

	@Mock
	private Database mockedDatabase;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		userFacade = new UserfacadeDB();
		userFacade.database = mockedDatabase;
	}

	@Test
	public void testGetAllUsers() {
		// Skapa mockad lista av Users
		List<User> users = new ArrayList<>();
		users.add(new User(1, "User 1"));
		users.add(new User(2, "User 2"));

		// Definiera beteendet för getAllUsers-metoden
		when(mockedDatabase.getAllUsers()).thenReturn(users);

		// Anropa metoden som ska testas
		List<User> result = userFacade.getAllUsers();

		// Kontrollera att rätt lista av Users returneras
		assertEquals(users, result);
		verify(mockedDatabase).getAllUsers();
	}

	@Test
	public void testGetUserById() {
		// Skapa en mockad User
		User user = new User(1, "User 1");

		// Definiera beteendet för getUserById-metoden
		when(mockedDatabase.getUserById(1)).thenReturn(user);

		// Anropa metoden som ska testas
		User result = userFacade.getUserById(1);

		// Kontrollera att rätt User returneras
		assertEquals(user, result);
		verify(mockedDatabase).getUserById(1);
	}

	@Test
	public void testAddOrUpdateUser() {
		// Skapa en mockad User
		User user = new User(1, "User 1");

		// Anropa metoden som ska testas
		userFacade.addOrUpdateUser(user);

		// Kontrollera att addOrUpdateUser-metoden anropas på rätt sätt
		verify(mockedDatabase).addOrUpdateUser(user);
	}

	@Test
	public void testDeleteUserFromDatabase() {
		// Anropa metoden som ska testas
		userFacade.deleteUserFromDatabase(1);

		// Kontrollera att deleteUserFromDatabase-metoden anropas på rätt sätt
		verify(mockedDatabase).deleteUserFromDatabase(1);
	}
}
