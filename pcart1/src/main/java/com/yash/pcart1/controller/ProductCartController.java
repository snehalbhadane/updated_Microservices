package com.yash.pcart1.controller;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

//import com.yash.pcart1.model.Product;
import com.yash.pcart1.model.ProductCart;
//import com.yash.pcart1.model.ProductRating;
import com.yash.pcart1.repository.ProductCartRepository;
import com.yash.pcart1.service.ProductCartService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/cart")
public class ProductCartController {
	@Autowired
	private ProductCartService pservice;

	//@Autowired
	//RestTemplate restTemplate;

	//@Autowired
	//WebClient.Builder webClientBuilder;

	@Autowired
	ProductCartRepository productCartRepo;
	
	@GetMapping("/show")
	public String show()
	{
		return "hello";

		
	}

	@PostMapping("/create")
	public void createCart(@RequestBody ProductCart cart)
	{

		System.out.println("creating a record");	
		pservice.addCart(cart);
	}
	/*@GetMapping(value="/getcart", headers = "Accept=application/json")
	public List<ProductCart> getProductCartList()
	{	
		/*List<ProductCart> cartList=  pservice.getList();
		return cartList.stream().map(cartsList ->{
			Product product = restTemplate.getForObject("http://localhost:8082/products/getAllProductDetails",Product.class);
			ProductRating productRating = restTemplate.getForObject("http://localhost:8083/rating/getAllRatings",ProductRating.class);	
			return new ProductCart(product.getProductId(),product.getProductName(),cartList.get(0).getPrice(),cartList.get(0).getDescription(),productRating.getRating());	

		}).collect(Collectors.toList());
		return pservice.getList();

	}*/
	//@CircuitBreaker(name="circuit",fallbackMethod="getFallbackCart")
	@GetMapping("/getcart")
	public Flux<ProductCart> getCart()//async reactive  data type,non-blocking,its like a stream(0 to n values) from webflux lib
	{
		return pservice.getList();
		/*List<ProductCart> cartList=pservice.getList();
		return Flux.fromIterable(cartList)
				.flatMap(cart->
				{
					WebClient productWebClient=webClientBuilder.baseUrl("http://localhost:8082/products").build();
					WebClient ratingWebClient=webClientBuilder.baseUrl("htp://localhost:8083/rating").build();
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
									
									
					
					
				});*/
		
	}
	/*
	 * public List<ProductCart> getFallbackCart(Throwable e) { return
	 * Arrays.asList(new ProductCart()); }
	 */
}



























/*
 * /* Find by id RestTemplate	-- From Database
		List<ProductCart> cartList = productCartRepo.findAll();
		return cartList.stream().map(cartsList -> {
			Product product = restTemplate.getForObject("http://localhost:8087/products/getAllProductDetails",Product.class);
			ProductRating productRating = restTemplate.getForObject("http://localhost:8088/ratingproduct/getAllRatings",ProductRating.class);
			return new ProductCart(product.getProductId(), product.getProductName(), cartList.get(0).getPrice(), cartList.get(0).getDescription(), productRating.getRating());
		}).collect(Collectors.toList());
 */
//cart=detail+rating

/*@GetMapping(value="/getcart", headers = "Accept=application/json")
public Flux<ProductCart> getCart() {
    List<ProductCart> cartList = pservice.getList();
    return Flux.fromIterable(cartList)
            .flatMap(cart -> {
WebClient productWebClient = webClientBuilder.baseUrl("http://localhost:8082/products").build();
WebClient ratingWebClient = webClientBuilder.baseUrl("http://localhost:8083/rating").build();

                return productWebClient.get()
                        .uri("/getAllProductDetails")
                        .retrieve()
                        .bodyToFlux(Product.class)
                        .zipWith(ratingWebClient.get().uri("/getAllRatings").retrieve().bodyToFlux(ProductRating.class),
                                (product, productRating) -> new ProductCart(product.getProductId(), product.getProductName(),
                                        cart.getPrice(), cart.getDescription(), productRating.getRating()))
                        .collectList()
                        .flatMapMany(Flux::fromIterable); // Flatten the List<ProductCart> to Flux<ProductCart>
            });


}*/




