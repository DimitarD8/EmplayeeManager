package com.example.adminpanel.service;

import com.example.adminpanel.exception.UserNotFoundException;
import com.example.adminpanel.model.Employee;
import com.example.adminpanel.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(String.valueOf(UUID.randomUUID()));
        repository.save(employee);
        return employee;
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("User wit id: " + id + " not found"));
    }

    public Employee findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new UserNotFoundException("User wit name: " + name + " not found"));
    }

    public Employee updateEmployee(Employee employee) {

        return repository.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        repository.delete(employee);
    }

    public void deleteEmployeeById(Long id) {
        repository.deleteById(id);
    }

    public void deleteEmployeeByName(String name) {
        repository.deleteEmployeeByName(name);
    }



}
