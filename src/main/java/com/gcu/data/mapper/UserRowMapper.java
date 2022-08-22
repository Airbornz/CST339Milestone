package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.UserEntity;

public class UserRowMapper implements RowMapper<UserEntity> {

	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new UserEntity(rs.getInt("customerID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), 
				rs.getString("phoneNumber"), rs.getString("password"));
	}

}
