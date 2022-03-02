package com.app.repository;

import com.app.models.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupRepo extends CrudRepository<Group,Long> {
}
