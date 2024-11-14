package com.yash.pratings.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.yash.pratings.model.ProductRating;


@Repository
public interface ProductRatingRepository extends JpaRepository<ProductRating, Integer> {

}
