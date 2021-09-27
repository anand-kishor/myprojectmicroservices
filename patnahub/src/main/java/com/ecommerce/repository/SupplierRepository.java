package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ecommerce.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

}
