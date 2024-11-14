package com.yash.pcart1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.pcart1.model.ProductCart;
@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart,Long> {

}
