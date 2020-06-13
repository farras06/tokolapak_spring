package com.cimb.tokolapak.service;

import java.util.Optional;

import com.cimb.tokolapak.entity.Product;

public interface ProductService {
		public Iterable<Product> getProducts(); 
		public Optional<Product> getProductById(int id);
}

