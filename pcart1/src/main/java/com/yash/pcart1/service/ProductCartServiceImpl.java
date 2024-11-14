package com.yash.pcart1.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.yash.pcart1.model.Product;
import com.yash.pcart1.model.ProductCart;
import com.yash.pcart1.model.ProductRating;
import com.yash.pcart1.repository.ProductCartRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import reactor.core.publisher.Flux;

@Service
public class ProductCartServiceImpl implements ProductCartService {
	
	@Autowired
	private ProductCartRepository repo;
	
	//@Autowired
	//RestTemplate restTemplate;

	@Autowired
	WebClient.Builder webClientBuilder;
	
	
	@CircuitBreaker(name="circuit",fallbackMethod="getFallbackCart")
	@Override
	//@TimeLimiter(name = "timelimiter", fallbackMethod = "getFallBack()")
	public Flux<ProductCart> getList() {
		List<ProductCart> cartList=repo.findAll();
		return Flux.fromIterable(cartList)
				.flatMap(cart->
				{
					WebClient productWebClient=webClientBuilder.baseUrl("http://localhost:8082/products").build();
					WebClient ratingWebClient=webClientBuilder.baseUrl("http://localhost:8083/rating").build();
					return  productWebClient.get()
							.uri("/getAllProductDetails")
							.retrieve()
							.bodyToFlux(Product.class)
							.zipWith(ratingWebClient.get()
									.uri("/getAllRatings")
									.retrieve()
									.bodyToFlux(ProductRating.class),
									(product,productRating)->new ProductCart(product.getProductId(),product.getProductName(),cart.getPrice(),
											cart.getDescription(),productRating.getRating()))
							.collectList()
							.flatMapMany(Flux::fromIterable);
									
									
					
					
				});
		
		//return repo.findAll();
	}

	
	  public List<ProductCart> getFallbackCart(Throwable e) 
	  { return Arrays.asList(new ProductCart()); 
	  }
	 
	@Override
	public void addCart(ProductCart cart) 
	{
		
		repo.save(cart);
		
	}

}
