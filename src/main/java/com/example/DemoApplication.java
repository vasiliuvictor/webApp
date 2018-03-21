package com.example;

import com.example.backend.persistance.domain.backend.Role;
import com.example.backend.persistance.domain.backend.User;
import com.example.backend.persistance.domain.backend.UserRole;
import com.example.backend.service.UserService;
import com.example.utils.PlansEnum;
import com.example.utils.RolesEnum;
import com.example.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		String username ="Victor";
		String email = "newEmail@yahoo.com";
		User user = UserUtils.createBasicUser(username,email);
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user,new Role(RolesEnum.BASIC)));
		LOG.debug("Creating user with username {}", user.getUsername());
		userService.createUser(user, PlansEnum.PRO,userRoles);
		LOG.info("user {} created",user.getUsername());

	}
}
