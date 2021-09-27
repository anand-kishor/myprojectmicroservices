package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

	@Query("select u from Product u where u.productId = :productId")
	Product findByProductId(@Param("productId") int productId);


}
