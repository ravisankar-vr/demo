package com.sample.service;

import com.sample.entity.Employee;
import com.sample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        List<Employee> empList = new ArrayList<Employee>();
        empList.addAll(employeeRepository.findAll());
        return empList;
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    public void SaveOrUpdate(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteById(Integer id){
        employeeRepository.deleteById(id);
    }





}
