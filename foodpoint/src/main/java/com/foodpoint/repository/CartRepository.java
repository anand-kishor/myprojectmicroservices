package com.foodpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodpoint.modal.CartItem;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Integer> {

}
