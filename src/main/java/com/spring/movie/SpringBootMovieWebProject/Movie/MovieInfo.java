package com.spring.movie.SpringBootMovieWebProject.Movie;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieInfo {
	private Logger logger = LoggerFactory.getLogger(MovieInfo.class);
	private String title;
	private String docid;
	private String movieSeq;
	private String titleEng;
	private String prodYear;
	private List<String> directors;
	private List<String> actors;
	private String genre;
	private String rating;
	private String ratingGrade;
	private List<String> posters;
	
	public MovieInfo() {
		this.actors = new ArrayList<>();
		this.posters = new ArrayList<>();
		this.directors = new ArrayList<>();
	}
	

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		if(directors == null) {
			logger.warn("No directors Data");
			System.out.println("No directors Data");
			return;
		}
		
		for(String director : directors) {
			this.directors.add(director);
		}
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title.indexOf("!HS ") != -1) {
			title = title.replace("!HS ", "");
		}
		if(title.indexOf(" !HE") != -1) {
			title = title.replace(" !HE", "");
		}
		
		this.title = title;
	}

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getMovieSeq() {
		return movieSeq;
	}

	public void setMovieSeq(String movieSeq) {
		this.movieSeq = movieSeq;
	}
	
	public String getTitleEng() {
		return titleEng;
	}

	public void setTitleEng(String titleEng) {
		this.titleEng = titleEng;
	}

	public String getProdYear() {
		return prodYear;
	}

	public void setProdYear(String prodYear) {
		this.prodYear = prodYear;
	}

	

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		if(actors.isEmpty()) {
			logger.warn("No actor Data");
			System.out.println("No actor Data");
			return;
		}
		
		for(String actor : actors) {
			this.actors.add(actor);
		}
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRatingGrade() {
		return ratingGrade;
	}

	public void setRatingGrade(String ratingGrade) {
		this.ratingGrade = ratingGrade;
	}

	public List<String> getPosters() {
		return posters;
	}

	public void setPosters(List<String> posters) {
		if(actors.isEmpty()) {
			logger.warn("No Poster Data");
			System.out.println("No Poster Data");
			return;
		}
		
		for(String poster : posters) {
			this.posters.add(poster);
		}
	}
}
