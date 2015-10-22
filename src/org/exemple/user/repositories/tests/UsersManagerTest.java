package org.exemple.user.repositories.tests;

import java.util.List;

import org.exemple.user.entities.User;
import org.exemple.user.repositories.UsersManager;
import org.junit.*;

public class UsersManagerTest {

	@Test
	public void test() {
		List<User> users = UsersManager.getInstance().getAll();
		Assert.assertEquals(4, users.size());
	}

}
