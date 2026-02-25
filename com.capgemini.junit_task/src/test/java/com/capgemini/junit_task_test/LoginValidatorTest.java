package com.capgemini.junit_task_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.capgemini.junit_task.LoginValidator;

public class LoginValidatorTest {
	
	//username's testcases
	
	@Test
	void testUsername() {
		assertTrue(LoginValidator.isValidUsername("Milind123"));
	}
	
	@Test
	void testUsernameWithSpecialChars() {
		assertFalse(LoginValidator.isValidUsername("Mil@234"));
	}
	
	@Test
	void testShortUsername() {
		assertFalse(LoginValidator.isValidUsername("abcd"));
	}
	
	@Test
	void testEmptyUsername() {
		assertFalse(LoginValidator.isValidUsername(""));
	}
	
	@Test
	void testNullUsername() {
		assertFalse(LoginValidator.isValidUsername(null));
	}
	
	
	//password's testcases
	
	@Test
    void testValidPassword() {
        assertTrue(LoginValidator.isValidPassword("Pass@123"));
    }

    @Test
    void testPasswordWithoutSpecialChar() {
        assertFalse(LoginValidator.isValidPassword("Pass1234"));
    }

    @Test
    void testShortPassword() {
        assertFalse(LoginValidator.isValidPassword("Pa@12"));
    }

    @Test
    void testSuccessfulLogin() {
        String result = LoginValidator.login("Milind123", "Pass@123");
        assertEquals("Login Successful", result);
    }

    
    @Test
    void testInvalidUsernameLogin() {
        String result = LoginValidator.login("Mi@", "Pass@123");
        assertEquals("Invalid Username", result);
    }

    // ❌ Invalid Password Login
    @Test
    void testInvalidPasswordLogin() {
        String result = LoginValidator.login("Milind123", "12345");
        assertEquals("Invalid Password", result);
    }
	
	
	
	
}
