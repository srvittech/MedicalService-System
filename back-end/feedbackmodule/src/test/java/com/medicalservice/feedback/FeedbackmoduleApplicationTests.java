package com.medicalservice.feedback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	public void getFeedbackTest() {
		Feedback feedback = new Feedback(1,101, "vijay", "Treatment is good", "No comments");
		when(feedbackRepo.findAll()).thenReturn(Stream.of(new Feedback(2,102, "revi", "Treatment is not good", "No comments"),
				new Feedback(3,103, "vijay", "Treatment is good", "No comments")).collect(Collectors.toList()));
		assertEquals(2, feedbackServiceImp.getFeedbacks().size());
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
		Feedback updatedFeedback = new Feedback(1,102, "kumar", "Treatment is  not good", "No comments");
		when(feedbackRepo.findById(feedback.getFeedbackId())).thenReturn(Optional.of(feedback));
		feedbackServiceImp.updateFeedback(updatedFeedback);
		assertEquals(feedback, feedbackServiceImp.findFeedbackById(1));	
	}

}
