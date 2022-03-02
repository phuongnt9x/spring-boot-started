package com.app.service;

import com.app.models.ProgrammingLanguage;
import com.app.repository.IProgLanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
