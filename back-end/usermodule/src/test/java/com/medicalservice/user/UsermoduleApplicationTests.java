package com.medicalservice.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
		User all = new User(1L,"userpassword","admin","admin123");
		when(userRepository.findById(1L)).thenReturn(Optional.of(all));
		assertEquals(all,userServiceImpl.getLogin(1L));			
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
		User user3 =new User(1L,"userpasswordabcd","admin","admin123");
		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

		assertEquals(user,userServiceImpl.updateLogin(user3));	
	}


}
