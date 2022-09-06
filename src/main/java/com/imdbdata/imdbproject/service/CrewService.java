package com.imdbdata.imdbproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imdbdata.imdbproject.model.Crew;
import com.imdbdata.imdbproject.repository.CrewRepository;


@Service
public class CrewService {
    @Autowired
    private CrewRepository crewRepository;

    public Crew saveCrew(Crew crew) {
        return crewRepository.save(crew);
    }

    public void saveBulk(List<Crew> crews) {
        crewRepository.saveAll(crews);
    }

    public Optional<Crew> getCrewById(String crewId) {
        return crewRepository.findById(crewId);
    }

    public void deeteCrew(Crew crew) {
        crewRepository.delete(crew);
    }

    public List<Crew> getAll() {
        return crewRepository.findAll();
    }

    public List<Crew> findSameDirectorWriter() {
        return crewRepository.findSameDirectorWriter();
    }

}
