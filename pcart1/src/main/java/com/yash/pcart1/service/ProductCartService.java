package com.yash.pcart1.service;

import java.util.List;

import com.yash.pcart1.model.ProductCart;

import reactor.core.publisher.Flux;

public interface ProductCartService {
	public Flux<ProductCart> getList();
	public void addCart( ProductCart cart);

}
