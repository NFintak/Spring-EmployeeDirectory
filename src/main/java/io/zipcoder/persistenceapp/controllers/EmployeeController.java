package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> showOne(@PathVariable("employeeId") Long id) {
        return new ResponseEntity<>(service.employeeById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<Employee>> showAll() {
        return new ResponseEntity<>(service.employeeIndex(), HttpStatus.OK);
    }

    //full employee update
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> updateAll(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return new ResponseEntity<>(service.updateEmployee(id, employee), HttpStatus.OK);
    }

    //update manager
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> updateManager(@PathVariable("id") Long id, @RequestBody Employee manager) {
        return new ResponseEntity<>(service.updateManager(id, manager), HttpStatus.OK);
    }

    //delete employee
    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> deleteOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.deleteEmployee(id), HttpStatus.OK);
    }

}
