package com.imdbdata.imdbproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdbdata.imdbproject.model.Title;

public interface TitleRepository extends JpaRepository<Title, String>{

}
