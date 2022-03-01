package com.example.springbootstarted.service;

import com.example.springbootstarted.entities.Employee;
import com.example.springbootstarted.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepo employeeRepo;
    @Override
    public Iterable<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepo.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepo.save(employee);

    }

    @Override
    public void remove(Long id) {
        employeeRepo.deleteById(id);

    }
}
