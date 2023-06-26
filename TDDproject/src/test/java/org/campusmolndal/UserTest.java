package org.campusmolndal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

	@Test
	void testGetId() {
		User user = new User(1,"Marcus");
		assertEquals(1,user.getId());
	}

	@Test
	void testGetName() {
		User user = new User(1,"marcus");
		assertEquals("marcus", user.getName());
	}

	@Test
	void setName() {
		User user = new User(1, "John");
		user.setName("Jane");
		assertEquals("Jane", user.getName());
	}
}