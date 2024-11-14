package com.yash.pdetails.service;
import java.util.List;
import java.util.Optional;
import com.yash.pdetails.model.Product;

public interface ProductDetailsService {
	public void createProductDetails(Product product);
	public void updateProductDetails(Product product);
	public Optional<List<Product>> getAllProductDetails();


}
