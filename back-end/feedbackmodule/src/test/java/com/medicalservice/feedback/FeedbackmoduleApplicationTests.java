package com.medicalservice.feedback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.medicalservice.feedback.model.Feedback;
import com.medicalservice.feedback.repository.FeedbackRepository;
import com.medicalservice.feedback.service.FeedbackServiceImp;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FeedbackmoduleApplicationTests {

	@Test
	void contextLoads() {
	}
	@InjectMocks
	private FeedbackServiceImp feedbackServiceImp;
	@Mock
	private FeedbackRepository feedbackRepo;
	
	@Test
	public void addFeedbackTest() {
		Feedback feedback = new Feedback(1,101, "vijay", "Treatment is good", "No comments");
		when(feedbackRepo.save(feedback)).thenReturn(feedback);
		assertEquals(feedback, feedbackServiceImp.addFeedback(feedback));

	}
	
	@Test
	public void findFeedbackByIdTest() {
		Feedback feedback = new Feedback(1,101, "vijay", "Treatment is good", "No comments");
		when(feedbackRepo.findById(feedback.getFeedbackId())).thenReturn(Optional.of(feedback));
		Feedback expected = feedbackServiceImp.findFeedbackById(feedback.getFeedbackId());
		verify(feedbackRepo).findById(feedback.getFeedbackId());

	}
	
	@Test

	public void updateFeedbackTest() {
		Feedback feedback = new Feedback(1,101, "vijay", "Treatment is good", "No comments");
		when(feedbackRepo.save(feedback)).thenReturn(feedback);
		feedback.setDescription("Treatment is not good");
		Feedback updatedFeedback = feedbackServiceImp.updateFeedback(feedback);
		assertThat(updatedFeedback.getDescription()).isEqualTo("Treatment is not good");

	}

}
