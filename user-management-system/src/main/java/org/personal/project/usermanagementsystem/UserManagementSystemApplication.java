package org.personal.project.usermanagementsystem;

import org.personal.project.usermanagementsystem.models.User;
import org.personal.project.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(UserManagementSystemApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("Mandavi", "Singh", "QA", "Pune");
		User user2 = new User("Manoj", "Kumar", "Developer", "Delhi");
		userRepository.save(user1);
		userRepository.save(user2);
	}
}
