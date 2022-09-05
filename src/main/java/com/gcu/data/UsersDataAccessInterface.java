package com.gcu.data;

public interface UsersDataAccessInterface <T>{

	public T findByEmail(String email);
	
}
