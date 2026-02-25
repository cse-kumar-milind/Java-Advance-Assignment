package com.capgemini.junit_task;


public class LoginValidator {
	
	private static final String usernameRegex = "^[a-zA-Z0-9]{5,15}$";

    // Password: min 8 chars, 1 letter, 1 digit, 1 special char
    private static final String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

 
    public static boolean isValidUsername(String username) {

        if (username == null || username.isEmpty()) {
            return false;
        }

        return username.matches(usernameRegex);
    }

    // Validate Password
    public static boolean isValidPassword(String password) {

        if (password == null || password.isEmpty()) {
            return false;
        }

        return password.matches(passwordRegex);
    }

    // Login Check
    public static String login(String username, String password) {

        if (!isValidUsername(username)) {
            return "Invalid Username";
        }

        if (!isValidPassword(password)) {
            return "Invalid Password";
        }

        return "Login Successful";
    }
}
