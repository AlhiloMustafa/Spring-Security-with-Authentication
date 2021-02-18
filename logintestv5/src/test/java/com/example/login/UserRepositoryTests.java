package com.example.login;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Example;
import org.springframework.test.annotation.Rollback;

import com.example.login.entity.User;
import com.example.login.repository.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testCreateUser() {
		

		User user = new User();
		user.setName("ddsfgdfadfao");
		user.setEmail("wwelhasgffadilo@gmail.com");
		user.setPassword("alhilo2020");

		User resultUser = repository.save(user);

		User createdUser = entityManager.find(User.class, resultUser.getId());

		assertThat(createdUser.getEmail()).isEqualTo(resultUser.getEmail());

	}

//	@Test
//	public void findbyemail() {
//
//
//		String enteredEmail = "welhasgffadilo@gmail.com";
//
//		User user = repository.findByEmail(enteredEmail);
//
//		assertThat(user).isNotNull();
//
//	}



}
