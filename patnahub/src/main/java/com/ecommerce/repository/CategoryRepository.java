package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
	
	
	@Query("select u from Category u where u.categoryId = :categoryId")
	public Category findByCategoryId(@Param("categoryId") int categoryId);

	
	

}
