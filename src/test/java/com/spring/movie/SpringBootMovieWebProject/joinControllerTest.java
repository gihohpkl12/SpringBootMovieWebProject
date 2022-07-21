package com.spring.movie.SpringBootMovieWebProject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.movie.SpringBootMovieWebProject.Domain.Member;
import com.spring.movie.SpringBootMovieWebProject.User.UserJoinInfo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class joinControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void joinTest() throws Exception {
		try {
			UserJoinInfo userInfo = new UserJoinInfo();
			userInfo.setEmail("aaa@aaa.com");
			userInfo.setId("testId");
			
			System.out.println("hi");
			
			 
			mockMvc.perform(post("/join", userInfo))
			.andExpect(status().isOk())
			.andDo(print());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
