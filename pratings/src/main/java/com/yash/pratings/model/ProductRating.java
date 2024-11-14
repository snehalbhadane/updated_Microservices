package com.yash.pratings.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Table(name = "product_rating")
public class ProductRating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	private double rating;
	
	
}
