package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;

@Service
public class UserDataService implements UsersDataAccessInterface<UserEntity>, DataAccessInterface<UserEntity>{
	
	@Autowired
	private UserRepository userRepository;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	
	public UserDataService(UserRepository userRepository, DataSource dataSource) {
		super();
		this.userRepository = userRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	

	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		
		try {
			Iterable<UserEntity> ordersIterable = userRepository.findAll();
			
			users = new ArrayList<UserEntity>();
			ordersIterable.forEach(users::add);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public boolean create(UserEntity user) {
		
		String sql = "INSERT INTO users(firstName, lastName, email, phoneNumber, password) VALUES(?, ?, ?, ?, ?)";
		
		try {
			jdbcTemplateObject.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getPassword());
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}



	@Override
	public UserEntity findById(int id) {
		try {
			return userRepository.findById(id).get();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public boolean update(UserEntity user) {
		String sql = "UPDATE users SET firstName=?, lastName=?, email=?, phoneNumber=?, password=? WHERE customerID=?";
		
		try {
			jdbcTemplateObject.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getPassword(), user.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}



	@Override
	public boolean delete(UserEntity user) {
		try {
			userRepository.delete(user);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public UserEntity findByEmail(String email) {
		return userRepository.findByEmail(email);
	}



}
