package com.yash.pdetails.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.yash.pdetails.model.Product;



@Repository
public interface ProductDetailsRepository extends JpaRepository<Product, Integer> {

}
