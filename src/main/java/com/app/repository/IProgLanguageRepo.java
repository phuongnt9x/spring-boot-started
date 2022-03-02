package com.app.repository;

import com.app.models.ProgrammingLanguage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgLanguageRepo extends CrudRepository<ProgrammingLanguage,Long> {
}
