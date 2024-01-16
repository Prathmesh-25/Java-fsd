package com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserAuthenticationTest {

	private UserAuthentication user;
	
	@BeforeEach
	public void BeforeEach() {
		user =new UserAuthentication();
		System.out.println("UserAuthentication Initiated");
	}
	@AfterEach
	public void AfterEach() {
		user=null;
		System.out.println("UserAuthentication stopped");
	}
	
	@Test
    public void test1() {
				assertFalse(user.authentication("",""));
		}
	
	@Test
	public void test2() {
		assertTrue(user.authentication("username@email.com","userpassword"));
		assertFalse(user.authentication("admin@email.com", "adminpassword"));
		assertNotEquals(user.authentication("username","username"), user.authentication("username@email.com", "userpassword"));
		assertEquals(user.authentication("username@email.com","userpassword"), user.authentication("username@email.com", "userpassword"));
	}
	
}