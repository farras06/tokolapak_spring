package com.cimb.tokolapak.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cimb.tokolapak.dao.ProductWETRepo;
import com.cimb.tokolapak.entity.ProductWET;

@RestController
@RequestMapping("/productWET")
@CrossOrigin

public class ProductWETController {
	
	@Autowired 
	private ProductWETRepo productWETRepo;
	
	
	@GetMapping 
	public Iterable<ProductWET> getProducts() {
		return productWETRepo.findAll();
	}
	
	@PostMapping
	public ProductWET addProduct (@RequestBody ProductWET productWET) {
		productWET.setId(0);
		return productWETRepo.save(productWET);
	
	}
	
	@DeleteMapping ("/{id}")
	public void deleteProduct (@PathVariable int id) {
		Optional <ProductWET> findProduct = productWETRepo.findById(id);
		productWETRepo.deleteById(id);
	}
	
	@PutMapping  ("/edit")
	public ProductWET editProduct (@RequestBody ProductWET productWET) {
		return productWETRepo.save(productWET);
	}
	
}
