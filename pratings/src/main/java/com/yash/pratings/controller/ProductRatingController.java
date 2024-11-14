package com.yash.pratings.controller;



import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pratings.model.ProductRating;
import com.yash.pratings.service.ProductRatingServiceImpl;



@RestController
@RequestMapping("/rating")
public class ProductRatingController {
	
	@Autowired
	ProductRatingServiceImpl productRatingServiceImpl;
	
	
	@PostMapping("/createProductRating")
	public void createProductRating(@RequestBody ProductRating productRating)
	{
		
		productRatingServiceImpl.createProductRating(productRating) ;
	}
	@GetMapping("/getAllRatings")
	public Optional <List<ProductRating>> getProductRating() {
		
		//return new ProductRating(productId,4);
		return productRatingServiceImpl.getAllProductRatingDetails();
	}
	
	
	
	
 
}