package com.spring.movie.SpringBootMovieWebProject.h2;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.spring.movie.SpringBootMovieWebProject.Movie.GettingMovieData;

/*
 * Spring Boot 구동 시에 h2 DB에 테이블을 생성.
 */

@Component
public class H2Runner implements ApplicationRunner {

	DataSource dataSource;
	Logger logger = LoggerFactory.getLogger(H2Runner.class);
	
	@Autowired
	public H2Runner(DataSource dataSource) {
		logger.info("H2 Runner init.");
		this.dataSource = dataSource;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		try(Connection connection = dataSource.getConnection()) {
			logger.info("H2 DB : " + connection.getMetaData().getURL());
			logger.info("H2 DB : " + connection.getMetaData().getUserName());
			
//			String sql = "CREATE TABLE USERSS(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
			String sql = "create table userinfo(membercd Integer not null, "
					+ "id varchar(255) not null, "
					+ "email varchar(255) not null, "
					+ "pw varchar(255) not null, "
					+ "primary key (membercd) )";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			
		} catch (Exception e) {
			logger.warn("H2 DB Error " + e.getMessage());
		}
	}

}
