package com.example.springbootstarted.repository;

import com.example.springbootstarted.entities.Group;
import org.springframework.data.repository.CrudRepository;

public interface IGroupRepo extends CrudRepository<Group,Long> {
}
