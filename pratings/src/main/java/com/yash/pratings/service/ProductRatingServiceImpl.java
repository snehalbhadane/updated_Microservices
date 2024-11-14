package com.yash.pratings.service;



import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.pratings.model.ProductRating;
import com.yash.pratings.repository.ProductRatingRepository;
@Service
public class ProductRatingServiceImpl implements ProductRatingService {
	
	@Autowired
	ProductRatingRepository productRatingRepo;

	@Override
	public Optional<List<ProductRating>> getAllProductRatingDetails() {
		// TODO Auto-generated method stub
		List<ProductRating> findAll = productRatingRepo.findAll();
		return Optional.ofNullable(findAll).filter(list -> !list.isEmpty());
	}

	@Override
	public void createProductRating(ProductRating productRating) {
		productRatingRepo.save(productRating);
		
	}

}
