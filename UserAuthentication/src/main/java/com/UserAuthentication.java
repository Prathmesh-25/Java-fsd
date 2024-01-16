package com;

public class UserAuthentication {
	
	public boolean authentication(String username,String password) {
		
		
		if((username==null)||(password==null)) {
			return false;
		}
	
		if(username.equalsIgnoreCase("username@email.com")) {
			if(password.equals("userpassword")) {
				System.out.println("Login Successful !!");
				return true;
			}
		}
		
		return false;
	
	}

}
