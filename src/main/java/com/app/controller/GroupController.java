package com.app.controller;

import com.app.models.Team;
import com.app.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/groups")
@PreAuthorize("hasRole('ADMIN')")
public class GroupController {
    @Autowired
    private IGroupService groupService;
    @GetMapping
    public ResponseEntity<Iterable<Team>> findAllGroup() {
        List<Team> teams = (List<Team>) groupService.findAll();
        if (teams.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Team> findGroupById(@PathVariable Long id) {
        Optional<Team> customerOptional = groupService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Team> saveGroup(@RequestBody Team team) {
        groupService.save(team);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateGroup(@PathVariable Long id, @RequestBody Team team) {
        Optional<Team> optionalGroup = groupService.findById(id);
        if (!optionalGroup.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        team.setId(optionalGroup.get().getId());
        groupService.save(team);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Team> deleteGroup(@PathVariable Long id) {
        Optional<Team> groupOptional = groupService.findById(id);
        if (!groupOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        groupService.remove(id);
        return new ResponseEntity<>(groupOptional.get(), HttpStatus.NO_CONTENT);
    }

}
