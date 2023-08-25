package com.sample.controller;

import com.sample.entity.Employee;
import com.sample.exception.RecordNotFoundException;
import com.sample.response.ResponseHandler;
import com.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class SampleController {

    @Autowired
    EmployeeService employeeService;
    public ResponseEntity<Object> getAllTutorials(@RequestParam(required = false) String title) {

        try {
            List<Employee> empList = new ArrayList<Employee>();

            if (title == null)
                employeeService.getAllEmployees().forEach(empList::add);
            else
                employeeService.getAllEmployees().forEach(empList::add);
                //tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

            if (empList.isEmpty()) {
                //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                throw new RecordNotFoundException("Employee Not Found!");
            }

            //return new ResponseEntity<>(empList, HttpStatus.OK);

            return ResponseHandler.generateResponse("Employee List !", HttpStatus.OK, empList);
        } catch (Exception e) {
            //return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseHandler.generateResponse("Something went wrong !", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }

    }
}
