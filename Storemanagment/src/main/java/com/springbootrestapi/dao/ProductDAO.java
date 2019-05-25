package com.springbootrestapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springbootrestapi.model.Product;
import com.springbootrestapi.repository.ProductRepository;



@Service
public class ProductDAO {
	
	@Autowired
	ProductRepository productRepository;
	
	/*to save employee */
	
	public Product save(Product emp) {
		return productRepository.save(emp);
	}
	
	/* search all employee*/
	public List<Product> findAll(){
		return productRepository.findAll();
	}

	/*get an employee by id*/
	public Product findone(Long empid) {
		return productRepository.findOne(empid);
	}
	
	/*delete an employee*/
	
	public void delete (Product emp) {
		productRepository.delete(emp);
	}
	
	
	
}

  
