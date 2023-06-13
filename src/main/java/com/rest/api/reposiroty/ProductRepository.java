package com.rest.api.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}	
