package com.imdbdata.imdbproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imdbdata.imdbproject.model.Name;
import com.imdbdata.imdbproject.repository.NameRepository;


@Service
public class NameService {
    @Autowired
    private NameRepository nameRepository;

    public Name saveName(Name name) {
        return nameRepository.save(name);
    }

    public void saveBulk(List<Name> names) {
        nameRepository.saveAll(names);
    }

    public Optional<Name> getNameById(String nameId) {
        return nameRepository.findById(nameId);
    }

    public void deeteName(Name name) {
        nameRepository.delete(name);
    }

    public List<Name> getAll() {
        return nameRepository.findAll();
    }

}
