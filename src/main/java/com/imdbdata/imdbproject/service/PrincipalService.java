package com.imdbdata.imdbproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imdbdata.imdbproject.model.Principal;
import com.imdbdata.imdbproject.repository.PrincipalRepository;


@Service
public class PrincipalService {
    @Autowired
    private PrincipalRepository principalRepository;

    public Principal savePrincipal(Principal principal) {
        return principalRepository.save(principal);
    }

    public void saveBulk(List<Principal> principals) {
        principalRepository.saveAll(principals);
    }

    public Optional<Principal> getPrincipalById(String principalId) {
        return principalRepository.findById(principalId);
    }

    public void deetePrincipal(Principal principal) {
        principalRepository.delete(principal);
    }

    public List<Principal> getAll() {
        return principalRepository.findAll();
    }

}
