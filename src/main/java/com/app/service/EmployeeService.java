package com.app.service;

import com.app.models.User;
import com.app.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService implements IUserService {
    @Autowired
    private IUserRepo employeeRepo;
    @Override
    public Iterable<User> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return employeeRepo.findById(id);
    }

    @Override
    public void save(User user) {
        employeeRepo.save(user);

    }

    @Override
    public void remove(Long id) {
        employeeRepo.deleteById(id);

    }
}
