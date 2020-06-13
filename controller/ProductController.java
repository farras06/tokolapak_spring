package com.cimb.tokolapak.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cimb.tokolapak.dao.ProductRepo;
import com.cimb.tokolapak.entity.Product;
import com.cimb.tokolapak.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public Iterable<Product> getProducts() {
		return productService.getProducts();
	}
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@DeleteMapping("/product{id}") 
		public void deleteProductByid(@PathVariable int id) {
			Optional<Product> product = this.productRepo.findById(id);
			
			if (product.equals(null) ) {
				throw new RuntimeException ("product with id" + id + "dose not exist");
			}
		}
	
	@PutMapping ("/product")
		public Product updateProduct(@RequestBody Product product) {
			Optional<Product> findProduct = productRepo.findById(product.getId());
				if ( findProduct.toString() == "Optional.empty")
					throw new RuntimeException ("Product with id" + product.getId() + "Does not exist");
				
				return productRepo.save(product);
		}
	
	

	
	
}
