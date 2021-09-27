package com.anand;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.anand.entities.User;
import com.anand.entities.UserRepository;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(ProjectApplication.class, args);
		UserRepository repo=context.getBean(UserRepository.class);
		
		
		/*
		 * User user1=new User(); user1.setName("anand");
		 * user1.setEmail("anandkishor.java@gmail.com");
		 * user1.setStatus("i am java developer");
		 * 
		 * User user2=new User(); user2.setName("saurav");
		 * user2.setEmail("sauravkishor.java@gmail.com");
		 * user2.setStatus("i am java developer");
		 * 
		 * User user3=new User(); user3.setName("anil");
		 * user3.setEmail("anilkishor.java@gmail.com");
		 * user3.setStatus("i am java developer");
		 * 
		 * User user4=new User(); user4.setName("amit");
		 * user4.setEmail("amitkishor.java@gmail.com");
		 * user4.setStatus("i am java developer");
		 * 
		 * User user5=new User(); user5.setName("anaya");
		 * user5.setEmail("anyakishor.java@gmail.com");
		 * user5.setStatus("i am java developer");
		 * 
		 * List<User> list=List.of(user1,user2,user3,user4,user5); repo.saveAll(list);
		 */
		/*
		 * Iterable<User> users=repo.findAll();
		 * users.forEach(user->System.out.println(user));
		 * 
		 * repo.deleteById(2); System.out.println("deleted");
		 * System.out.println("............................");
		 * 
		 * Optional<User> optional=repo.findById(6); User user=optional.get();
		 * user.setName("ankita"); User result=repo.save(user);
		 * System.out.println("update user 6"+user);
		 * System.out.println("//////////////////////");
		 */
		/*
		 * Iterable<User> allUsers=repo.findAll();
		 * allUsers.forEach(usersall->System.out.println(usersall));
		 * repo.deleteAll(allUsers); System.out.println("deleted all");
		 */
		
		/*
		 * List<User> users=repo.findByName("anand");
		 * users.forEach(e->System.out.println(e));
		 */
		List<User> allUsers=repo.findByNameAndEmail("anand", "anandkishor.java@gmail.com");
		allUsers.forEach(m->System.out.println(m));
		
		
		
		
	}

}
