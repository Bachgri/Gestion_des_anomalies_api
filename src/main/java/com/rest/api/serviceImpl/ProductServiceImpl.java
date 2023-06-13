package com.rest.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.entity.Product;
import com.rest.api.reposiroty.ProductRepository;
import com.rest.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	@Override
	public List<Product> getAll() { 
		return productRepository.findAll();
	}

	@Override
	public Product post(Product p) { 
		return productRepository.save(p);
	}

	@Override
	public Product put(Product p) {
		return null;
	}

	@Override
	public Product get(Long id) { 
		return productRepository.findById(id).get();
	}

	@Override
	public Product delete(long p) {
		Product pp = productRepository.findById(p).get();
		productRepository.delete(pp);
		return pp;
	}

}
