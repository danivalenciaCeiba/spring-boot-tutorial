package com.ceiba;

import static org.junit.Assert.assertTrue;

import com.ceiba.domain.entity.User;
import com.ceiba.domain.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CeibaApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void createUserTest() {
		User user = new User();
		user.setId(1);
		user.setName("Daniel Mauricio");
		user.setPassword(encoder.encode("123"));
		User userResponse = this.userRepository.save(user);
		assertTrue(userResponse.getPassword().equalsIgnoreCase(user.getPassword()));

	}

}
