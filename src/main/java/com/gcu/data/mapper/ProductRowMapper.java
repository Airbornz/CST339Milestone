package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserEntity;

public class ProductRowMapper implements RowMapper<ProductEntity> {

	@Override
	public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ProductEntity(rs.getInt("productID"), rs.getString("productName"), rs.getString("productType"));
	}

}
