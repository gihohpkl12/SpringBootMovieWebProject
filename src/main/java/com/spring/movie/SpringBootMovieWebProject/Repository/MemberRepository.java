package com.spring.movie.SpringBootMovieWebProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.movie.SpringBootMovieWebProject.Domain.Member;


public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByIdAndEmail(String id, String email);
}
