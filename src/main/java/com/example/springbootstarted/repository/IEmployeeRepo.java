package com.example.springbootstarted.repository;

import com.example.springbootstarted.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeRepo extends CrudRepository<Employee,Long> {
}
