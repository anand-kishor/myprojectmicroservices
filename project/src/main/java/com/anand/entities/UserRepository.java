package com.anand.entities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
	
	public List<User> findByName(String name);
	public List<User> findByNameAndEmail(String name,String email);

}
