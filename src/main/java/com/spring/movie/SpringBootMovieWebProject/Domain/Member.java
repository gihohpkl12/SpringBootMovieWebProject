package com.spring.movie.SpringBootMovieWebProject.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int membercd;
	private String id;
	private String pw;
	private String email;
	
	public int getMembercd() {
		return membercd;
	}
	public void setMembercd(int membercd) {
		this.membercd = membercd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
