package com.spring.movie.SpringBootMovieWebProject.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movie.SpringBootMovieWebProject.Movie.GettingMovieData;
import com.spring.movie.SpringBootMovieWebProject.Movie.MovieInfo;

@RestController
public class TestPageController {

	@GetMapping("")
	public String initPage() {
		ArrayList<String> a = new ArrayList<>();
		a.add("title=avatar");
		String aaa = "test";
		if(GettingMovieData.getMovieData(a).size() != 0) {
			ArrayList<MovieInfo> aa = (ArrayList)GettingMovieData.getMovieData(a);
			aaa = aa.get(0).getDocid();
		} else {
			System.out.println("null!!!!!!!!!!!!!!!!!!!!!!");
		}

		
		return aaa;
	}
}
