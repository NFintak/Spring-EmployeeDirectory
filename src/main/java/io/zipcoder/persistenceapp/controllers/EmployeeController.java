package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.EmployeeRepo;
//import io.zipcoder.persistenceapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("API/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo repo;

    //create employee
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee saved = repo.save(employee);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    //update all employee info sans manager
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateInfo(@PathVariable Long id, @RequestBody Employee updated) {
        Employee toUpdate = repo.findOne(id);
        if (toUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        toUpdate.setEmployeeId(updated.getEmployeeId());
        toUpdate.setFirstName(updated.getFirstName());
        toUpdate.setLastName(updated.getLastName());
        toUpdate.setTitle(updated.getTitle());
        toUpdate.setPhoneNum(updated.getPhoneNum());
        toUpdate.setEmail(updated.getEmail());
        toUpdate.setHireDate(updated.getHireDate());
        toUpdate.setDeptNum(updated.getDeptNum());
        Employee saved = repo.save(toUpdate);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    //update manager
    @PutMapping("/{id}/manager")
    public ResponseEntity<Employee> updateManager(@PathVariable Long id, @RequestParam Long manager) {
        Employee employee = repo.findOne(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employee.setManager(manager);
        Employee saved = repo.save(employee);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    //get employee info
    @GetMapping("/{id}/info")
    public ResponseEntity<Employee> showOne(@PathVariable Long id) {
        Employee employee = repo.findOne(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    //get employees with no manager
    @GetMapping("/no-manager")
    public ResponseEntity<Iterable<Employee>> getNoManagers() {
        Iterable<Employee> noManagers = repo.findNoManager();
        return new ResponseEntity<>(noManagers, HttpStatus.OK);
    }

    //get direct reports
    @GetMapping("/manager/{managerId}")
    public ResponseEntity<Iterable<Employee>> getByManager(@PathVariable Long managerId) {
        Iterable<Employee> byManager = repo.findByManager(managerId);
        return new ResponseEntity<>(byManager, HttpStatus.OK);
    }

    //get direct/indirect reports

    //get reporting hierarchy

    //get by dept



}
