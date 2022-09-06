package com.imdbdata.imdbproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.imdbdata.imdbproject.model.Crew;

public interface CrewRepository extends JpaRepository<Crew, String>{

    @Query(value = "Select * from Crew where directors NOT LIKE '%N%' AND writers NOT LIKE '%N%'", nativeQuery = true)
    List<Crew> findSameDirectorWriter();
    
}
