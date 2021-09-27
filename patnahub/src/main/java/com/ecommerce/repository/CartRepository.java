package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.CartItem;

@Repository
public interface CartRepository extends JpaRepository<CartItem,Integer>{
	
	@Query("select u from CartItem u where u.cardItemId = :cardItemId")
	CartItem findBycardItemId(@Param("cardItemId") int cardItemId);
	@Query("select u from CartItem u where u.username = :username")
	List<CartItem> findAllByCardItemUsername(@Param("username") String username);


}
