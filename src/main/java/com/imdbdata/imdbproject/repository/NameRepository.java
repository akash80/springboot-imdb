package com.imdbdata.imdbproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdbdata.imdbproject.model.Name;

public interface NameRepository extends JpaRepository<Name, String>{

}
