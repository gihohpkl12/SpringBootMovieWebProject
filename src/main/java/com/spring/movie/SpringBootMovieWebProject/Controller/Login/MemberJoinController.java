package com.spring.movie.SpringBootMovieWebProject.Controller.Login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.movie.SpringBootMovieWebProject.Service.MemberJoinCheck;
import com.spring.movie.SpringBootMovieWebProject.User.UserJoinInfo;

@Controller
public class MemberJoinController {

	private static Logger logger = LoggerFactory.getLogger(MemberJoinController.class);
	MemberJoinCheck memberJoinCheck;
	
	@Autowired
	public MemberJoinController(MemberJoinCheck memberJoinCheck) {
		this.memberJoinCheck = memberJoinCheck;
	}
	
	
	@PostMapping("/join")
	public ModelAndView join(ModelAndView modelAndView, UserJoinInfo userJoinInfo) {
		logger.info("request member join");
		
		boolean joinCheck = memberJoinCheck.idAndEmailCheck(userJoinInfo.getId(), userJoinInfo.getEmail());
		
		
		if(!joinCheck) {
			logger.info("member join fail");
			modelAndView.setViewName("joinfail");
		} else {
			modelAndView.setViewName("/");
		}
		
		
		
		return modelAndView;
	}
}
