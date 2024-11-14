package com.yash.pratings.service;



import java.util.List;

import java.util.Optional;

import com.yash.pratings.model.ProductRating;



public interface ProductRatingService {
	public void createProductRating(ProductRating productRating);
	public Optional<List<ProductRating>> getAllProductRatingDetails();
	


}
