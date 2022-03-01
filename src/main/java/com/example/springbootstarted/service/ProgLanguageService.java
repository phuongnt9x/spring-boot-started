package com.example.springbootstarted.service;

import com.example.springbootstarted.entities.ProgrammingLanguage;
import com.example.springbootstarted.repository.IProgLanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProgLanguageService implements IProgLanguageService{
    @Autowired
    private IProgLanguageRepo progLanguageRepo;
    @Override
    public Iterable<ProgrammingLanguage> findAll() {
        return progLanguageRepo.findAll();
    }

    @Override
    public Optional<ProgrammingLanguage> findById(Long id) {
        return progLanguageRepo.findById(id);
    }

    @Override
    public void save(ProgrammingLanguage programmingLanguage) {
        progLanguageRepo.save(programmingLanguage);

    }

    @Override
    public void remove(Long id) {
        progLanguageRepo.deleteById(id);

    }
}
