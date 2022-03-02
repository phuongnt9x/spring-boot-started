package com.app.controller;

import com.app.models.ProgrammingLanguage;
import com.app.service.IProgLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/programming_lang")
public class ProgLangController {
    @Autowired
    private IProgLanguageService progLanguageService;
    @GetMapping
    public ResponseEntity<Iterable<ProgrammingLanguage>> findAllGroup() {
        List<ProgrammingLanguage> languages = (List<ProgrammingLanguage>) progLanguageService.findAll();
        if (languages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> findGroupById(@PathVariable Long id) {
        Optional<ProgrammingLanguage> programmingLanguageOptional = progLanguageService.findById(id);
        if (!programmingLanguageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(programmingLanguageOptional.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProgrammingLanguage> saveGroup(@RequestBody ProgrammingLanguage group) {
        progLanguageService.save(group);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> updateGroup(@PathVariable Long id, @RequestBody ProgrammingLanguage group) {
        Optional<ProgrammingLanguage> languageOptional = progLanguageService.findById(id);
        if (!languageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        group.setId(languageOptional.get().getId());
        progLanguageService.save(group);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> deleteGroup(@PathVariable Long id) {
        Optional<ProgrammingLanguage> groupOptional = progLanguageService.findById(id);
        if (!groupOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        progLanguageService.remove(id);
        return new ResponseEntity<>(groupOptional.get(), HttpStatus.NO_CONTENT);
    }
}
