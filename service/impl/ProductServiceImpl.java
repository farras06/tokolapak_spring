package com.cimb.tokolapak.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cimb.tokolapak.dao.ProductRepo;
import com.cimb.tokolapak.entity.Product;
import com.cimb.tokolapak.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	@Transactional
	public Iterable<Product> getProducts() {
		return productRepo.findAll();
	}
	
	@Override
	@Transactional
	public Optional<Product> getProductById(int id) {
		return productRepo.findById(id);
	}
	
}
