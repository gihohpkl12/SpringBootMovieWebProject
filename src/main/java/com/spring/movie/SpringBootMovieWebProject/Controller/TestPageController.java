package com.spring.movie.SpringBootMovieWebProject.Controller;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movie.SpringBootMovieWebProject.Movie.GettingMovieData;
import com.spring.movie.SpringBootMovieWebProject.Movie.MovieInfo;
import com.spring.movie.SpringBootMovieWebProject.User.UserJoinInfo;
import com.spring.movie.SpringBootMovieWebProject.h2.H2Runner;

@RestController
public class TestPageController {
	
	Logger logger = LoggerFactory.getLogger(TestPageController.class);
	
	@GetMapping("/aa")
	public String a (UserJoinInfo userJoinInfo) {
		System.out.println(userJoinInfo);
		return "good";
	}
	
	@GetMapping("")
	public String initPage() {
		ArrayList<String> a = new ArrayList<>();
		a.add("title=avatar");
		String aaa = "test";
		ArrayList<MovieInfo> ta = (ArrayList<MovieInfo>)GettingMovieData.getMovieData(a);
		if(ta.size() != 0) {
			aaa = "";
			aaa+=ta.get(0).getCompany();
			aaa+="\n";
			aaa+=ta.get(0).getActors();
			aaa+="\n";
			aaa+=ta.get(0).getDocid();
			aaa+="\n";
			aaa+=ta.get(0).getGenre();
			aaa+="\n";
			aaa+=ta.get(0).getNation();
			aaa+="\n";
			aaa+=ta.get(0).getTitle();
			aaa+="\n";
			aaa+=ta.get(0).getTitleEng();
			aaa+="\n";
			aaa+=ta.get(0).getMovieSeq();
			aaa+="\n";
			aaa+=ta.get(0).getPlot();
			aaa+="\n";
			for(int j = 0; j < ta.get(0).getDirectors().size(); j++) {
				aaa+= ta.get(0).getDirectors().get(j);
			}
			aaa+="\n";
			for(int j = 0; j < ta.get(0).getPosters().size(); j++) {
				aaa+= ta.get(0).getPosters().get(j);
			}
			aaa+="\n";
			aaa+=ta.get(0).getRatingDate();
			
			aaa+="\n";
			aaa+=ta.get(0).getRatingGrade();
		} else {
			System.out.println("null!!!!!!!!!!!!!!!!!!!!!!");
		}

		
		return aaa;
	}
}
