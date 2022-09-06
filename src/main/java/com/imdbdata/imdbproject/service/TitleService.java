package com.imdbdata.imdbproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imdbdata.imdbproject.model.Title;
import com.imdbdata.imdbproject.repository.TitleRepository;


@Service
public class TitleService {
    @Autowired
    private TitleRepository titleRepository;

    public Title saveTitle(Title title) {
        return titleRepository.save(title);
    }

    public void saveBulk(List<Title> titles) {
        titleRepository.saveAll(titles);
    }

    public Optional<Title> getTitleById(String titleId) {
        return titleRepository.findById(titleId);
    }

    public void deeteTitle(Title title) {
        titleRepository.delete(title);
    }

    public List<Title> getAll() {
        return titleRepository.findAll();
    }

}
