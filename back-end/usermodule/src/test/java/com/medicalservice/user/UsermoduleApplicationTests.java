package com.medicalservice.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
=======
>>>>>>> origin/sourav

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.medicalservice.user.model.User;
import com.medicalservice.user.repository.UserRepository;
import com.medicalservice.user.service.UserServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UsermoduleApplicationTests {

	@Test
	void contextLoads() {
	}
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	@Mock
	private UserRepository userRepository;
	
	@Test
	public void getLoginTest() {
		List<User> all = new ArrayList<>();
		all.add(new User(1L,"userpassword","admin","admin123"));
		all.add(new User(2L,"userpassword","kiosk","kiosk123"));
		when(userRepository.findAll()).thenReturn(all);
		assertEquals(all,userServiceImpl.getLogin());			
	}
	
}
