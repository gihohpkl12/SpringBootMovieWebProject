package com.spring.movie.SpringBootMovieWebProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.movie.SpringBootMovieWebProject.Domain.Member;
import com.spring.movie.SpringBootMovieWebProject.Repository.MemberRepository;

@Service
public class MemberJoinCheck {

	@Autowired
	MemberRepository memberRepository;
	
	public boolean idAndEmailCheck(String id, String email) {
		Member result = memberRepository.findByIdAndEmail(id, email);
		if(result == null) {
			return false;
		} else {
			System.out.println(result.getEmail()+" "+result.getId());
		}
		return true;
	}
}
