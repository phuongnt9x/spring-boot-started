package com.app.repository;

import com.app.models.ERole;
import com.app.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepo extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
