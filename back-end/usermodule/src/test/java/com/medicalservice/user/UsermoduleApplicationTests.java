package com.medicalservice.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.medicalservice.user.model.User;
import com.medicalservice.user.repository.UserRepository;
import com.medicalservice.user.service.UserServiceImpl;

@SpringBootTest
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
	@Test
	public void  addLoginTest() {
		User user =new User(1L,"userpassword","admin","admin123");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userServiceImpl.addLogin(user));
	}
	@Test
	public void updateLoginTest() {
		User user =new User(1L,"userpassword","admin","admin123");
		User user1 =new User(2L,"userpassword","admin","admin123");
		User user2 =new User(3L,"userpassword","admin","admin123");
		User user3 =new User(1L,"userpasswordabcd","admin","admin123");
		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		when(userRepository.findById(user1.getId())).thenReturn(Optional.of(user1));
		when(userRepository.findById(user2.getId())).thenReturn(Optional.of(user2));
		userServiceImpl.updateLogin(user3);
		assertEquals(user,userServiceImpl.updateLogin(user3));	
	}

}
