package ru.kata.spring.boot_security.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityDemoApplication implements ApplicationRunner {

	private final UserService userService;

	public SpringBootSecurityDemoApplication(UserService userService) {
		this.userService = userService;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		User user = new User();

		user.setUsername("user");
		user.setEmail("user@gmail.com");
		user.setPassword("user");
		user.setRoles(Collections.singleton(new Role(user.getId(), "ROLE_USER")));

		User admin = new User();

		Set<Role> adminSetRoles = new HashSet<>();
		adminSetRoles.add(new Role(user.getId(), "ROLE_USER"));
		adminSetRoles.add(new Role(user.getId(), "ROLE_ADMIN"));

		admin.setUsername("admin");
		admin.setEmail("admin@gmail.com");
		admin.setPassword("admin");
		admin.setRoles(adminSetRoles);

		userService.saveUser(user);
		userService.saveUser(admin);

		System.out.println("GET USER: " + userService.getUserList().get(0));
		System.out.println("GET ADMIN: " + userService.getUserList().get(1));
	}
}
