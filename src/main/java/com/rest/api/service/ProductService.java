package com.rest.api.service;

import java.util.List;

import com.rest.api.entity.Product;

public interface ProductService {
	public List<Product> getAll();
	public Product post(Product p);
	public Product put(Product p);
	public Product get(Long id);
	public Product delete(long p);
}
