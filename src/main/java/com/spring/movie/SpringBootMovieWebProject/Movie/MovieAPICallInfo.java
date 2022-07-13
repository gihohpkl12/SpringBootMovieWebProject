package com.spring.movie.SpringBootMovieWebProject.Movie;

import java.util.List;

/*
 ============================================================
 * 넘어오는 query는 title=아바타 등의 형식
 ============================================================ 
 */

public class MovieAPICallInfo {
	private static final String apiUrl = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json.jsp?collection=kmdb_new&detail=";
	private static final String apiKey = "D722C190CDDFEF5B52F98E4A5571523534DC68D76B36846943525C22B4A43";
		 
	public static String makeUrl(List<String> querys) {
		StringBuilder sb = new StringBuilder();
		sb.append(apiUrl);
		sb.append("N&ServiceKey=");
		sb.append(apiKey);
		sb.append("&");
		
		for(int i = 0; i < querys.size(); i++) {
			sb.append(querys.get(i));
			if(i != querys.size()-1) {
				sb.append("&");
			}
		}
		
		return sb.toString();
	}
	
	public static String makeDetailUrl(List<String> querys) {
		StringBuilder sb = new StringBuilder();
		sb.append(apiUrl);
		sb.append("Y&ServiceKey=");
		sb.append(apiKey);
		sb.append("&");
		
		for(int i = 0; i < querys.size(); i++) {
			sb.append(querys.get(i));
			if(i != querys.size()-1) {
				sb.append("&");
			}
		}
		
		return sb.toString();
	}
}
