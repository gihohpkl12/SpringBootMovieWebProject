package com.spring.movie.SpringBootMovieWebProject.Movie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GettingMovieData {

	private static Logger logger = LoggerFactory.getLogger(GettingMovieData.class);

	public static List<MovieInfo> getMovieData(List<String> querys) {
		ArrayList<MovieInfo> results = new ArrayList<>();
		String kmdbUrl = MovieAPICallInfo.makeDetailUrl(querys);
		HttpURLConnection con;
		URL url;

		try {
			logger.info("URL --> " + URLEncoder.encode(kmdbUrl,"utf-8").toString());
			url = new URL(kmdbUrl);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-type", "application/json");
			
			if (con.getResponseCode() == con.HTTP_OK) {
				logger.info("Resonse OK");
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				
				/*
				 * KMDB JSON 구조
				 * total 
				 *  - JSONArray : data
				 *     - JSONArray : result
				 */
				JSONObject totalData = JSONObject.fromObject(sb.toString());
				JSONArray data = totalData.getJSONArray("Data");
				JSONArray resultData = data.getJSONObject(0).getJSONArray("Result");
				for(int i = 0; i < resultData.size(); i++) {
					MovieInfo movie = new MovieInfo();
					JSONObject getData = resultData.getJSONObject(i);
					
					movie.setDocid(getData.getString("DOCID"));
					movie.setMovieSeq(getData.getString("movieSeq"));
					movie.setTitle(getData.getString("title"));
					movie.setProdYear(getData.getString("prodYear"));
					movie.setTitleEng(getData.getString("titleEng"));
					movie.setNation(getData.getString("nation"));
					movie.setCompany(getData.getString("company"));
					movie.setPlot(getData.getString("plot"));
					movie.setRuntime(getData.getString("runtime"));
					movie.setGenre(getData.getString("genre"));
					
					ArrayList<String> directors = new ArrayList<>();
					JSONArray directorData =  getData.getJSONArray("director");
					for(int j = 0; j < directorData.size(); j++) {
						directors.add(directorData.getJSONObject(j).getString("directorNm"));
					}
					movie.setDirectors(directors);
					
					ArrayList<String> actors = new ArrayList<>();
					JSONArray actorData = getData.getJSONArray("actor");
					for(int j = 0; j < actorData.size(); j++) {
						actors.add(actorData.getJSONObject(j).getString("actorNm"));
					}
					
					JSONArray ratingData = getData.getJSONArray("rating").getJSONArray(1);
					movie.setRatingGrade(ratingData.getJSONObject(0).getString("ratingGrade"));
					movie.setRatingDate(ratingData.getJSONObject(0).getString("ratingDate"));

					String[] temp = getData.getString("posters").split("\\|");
					ArrayList<String> posters = new ArrayList<>();
					for(int j = 0; j < temp.length; j++) {
						posters.add(temp[j]);
					}
					movie.setPosters(posters);
					
					results.add(movie);
				}
			} else {
				logger.warn("KMDB Connection Fail. Error Code :"+con.getResponseCode());
			}
		} catch (Exception e) {
			logger.warn("Fail to get KMDB Movie Data");
			logger.warn("--> " + e.getMessage());
		}
		return results;
	}
}
