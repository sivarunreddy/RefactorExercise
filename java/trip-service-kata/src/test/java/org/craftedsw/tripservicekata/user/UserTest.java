package org.craftedsw.tripservicekata.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class UserTest {

	private User user;
	private User friend=new User();
	
	@Before
	public void setup(){
		user=new User();
		user.addFriend(friend);
	}
	
	@Test
	public void test_isFirend_with_not_a_friend(){
		assertFalse(user.isFriend(new User()));
	}
	
	@Test
	public void test_isFirend_with_a_friend(){
		assertTrue(user.isFriend(friend));
	}
}
