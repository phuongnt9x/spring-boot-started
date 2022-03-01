package com.example.springbootstarted.repository;

import com.example.springbootstarted.entities.ProgrammingLanguage;
import org.springframework.data.repository.CrudRepository;

public interface IProgLanguageRepo extends CrudRepository<ProgrammingLanguage,Long> {
}
