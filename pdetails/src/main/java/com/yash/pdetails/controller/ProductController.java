package com.yash.pdetails.controller;



import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pdetails.model.Product;
import com.yash.pdetails.service.ProductDetailsServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductDetailsServiceImpl productDetailsServiceImpl;
	
	@GetMapping("/getAllProductDetails")
	public Optional<List<Product>> getProductDetails() {
		
		//return new Product(productId,"test");
		return productDetailsServiceImpl.getAllProductDetails();
	}
	@PostMapping("/createProductDetails")
	public void createProductDetails(@RequestBody Product product) {
		
		
		productDetailsServiceImpl.createProductDetails(product);
	
	}
	
	@PutMapping("/updateProductDetails")
	public void updateProductDetails(@RequestBody Product product) {
		
		
		productDetailsServiceImpl.updateProductDetails(product);
	
	}
	
}