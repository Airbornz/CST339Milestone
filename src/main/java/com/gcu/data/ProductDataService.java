package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductRepository;

@Service
public class ProductDataService implements DataAccessInterface<ProductEntity>{
	
	@Autowired
	private ProductRepository productRepo;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	
	public ProductDataService(ProductRepository productRepo, DataSource dataSource) {
		super();
		this.productRepo = productRepo;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	

	@Override
	public List<ProductEntity> findAll() {
		List<ProductEntity> users = new ArrayList<ProductEntity>();
		
		try {
			Iterable<ProductEntity> ordersIterable = productRepo.findAll();
			
			users = new ArrayList<ProductEntity>();
			ordersIterable.forEach(users::add);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public boolean create(ProductEntity prod) {
		
		String sql = "INSERT INTO products(productName, productType) VALUES(?, ?)";
		
		try {
			jdbcTemplateObject.update(sql, prod.getProductName(), prod.getProductType());
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}



	@Override
	public ProductEntity findById(int id) {
		try {
			return productRepo.findById(id).get();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public boolean update(ProductEntity prod) {
		String sql = "UPDATE products SET productName=?, productType=? WHERE productID=?";
		
		try {
			System.out.println("Trying to update with "+prod.getProductName()+" "+prod.getProductType()+" "+prod.getId());
			jdbcTemplateObject.update(sql, prod.getProductName(), prod.getProductType(), prod.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}



	@Override
	public boolean delete(ProductEntity user) {
		try {
			productRepo.delete(user);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
