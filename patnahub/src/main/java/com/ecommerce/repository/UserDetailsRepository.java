package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ecommerce.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {

	@Query("select u from UserDetails u where u.username = :username")
	UserDetails getUsername(@Param ("username")String username);
	
	
	
	  @Query("select u from UserDetails u where u.userAddress = :userAddress")
	  String getUserAddress();
	 
}
