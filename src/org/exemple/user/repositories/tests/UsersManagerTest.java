package org.exemple.user.repositories.tests;

import java.util.List;

import org.exemple.user.entities.User;
import org.exemple.user.repositories.UsersManager;
import org.junit.*;

public class UsersManagerTest {

	@Test
	public void testGetAll() {
		List<User> users = UsersManager.getInstance().getAll();
		Assert.assertEquals(10, users.size());
	}
	
	@Test
	public void testGetByIDOK() {
		User user = UsersManager.getInstance().getByID(10);
		Assert.assertEquals(10, user.getId());
	}
	
	@Test
	public void testGetByIDKO() {
		User user = UsersManager.getInstance().getByID(1);
		Assert.assertEquals(null, user);
	}

	@Test
	public void testAddRemove(){
		User user = UsersManager.getInstance().getByID(10);
		Assert.assertEquals(10, user.getId());
		User result = UsersManager.getInstance().remove(10);
		Assert.assertEquals(10,result.getId());
		result = UsersManager.getInstance().getByID(10);
		Assert.assertEquals(null,result);
		UsersManager.getInstance().add(user);
		result = UsersManager.getInstance().getByID(10);
		Assert.assertEquals(10, result.getId());
	}	
}
