package com.app.service;

import com.app.models.Group;
import com.app.repository.IGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private IGroupRepo groupRepo;
    @Override
    public Iterable<Group> findAll() {
        return groupRepo.findAll();
    }

    @Override
    public Optional<Group> findById(Long id) {
        return groupRepo.findById(id);
    }

    @Override
    public void save(Group group) {
        groupRepo.save(group);
    }

    @Override
    public void remove(Long id) {
        groupRepo.deleteById(id);

    }
}
