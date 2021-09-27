package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.OrderDetails;

@Repository
@Transactional
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {
	
	@Query("select u from OrderDetails u where u.orderId = :orderId")
	OrderDetails findByOrderId(@Param("orderId") int orderId);

	/* void updateCart(String username); */


}
