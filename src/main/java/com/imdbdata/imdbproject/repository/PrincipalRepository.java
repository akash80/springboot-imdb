package com.imdbdata.imdbproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdbdata.imdbproject.model.Principal;

public interface PrincipalRepository extends JpaRepository<Principal, String>{

}
