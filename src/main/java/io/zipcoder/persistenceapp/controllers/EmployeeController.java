package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.EmployeeRepo;
//import io.zipcoder.persistenceapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("API/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo repo;
//    private EmployeeService service;
//
//    public EmployeeController(EmployeeService service) {
//        this.service = service;
//    }

    @PostMapping
//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee toSave = repo.save(employee);
        return new ResponseEntity<>(toSave, HttpStatus.CREATED);
        //return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> showOne(@PathVariable("employeeId") Long id) {
        Employee employee = repo.findOne(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
        //return new ResponseEntity<>(service.employeeById(id), HttpStatus.OK);
    }

//    @GetMapping("/all")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Iterable<Employee>> showAll() {
//        return new ResponseEntity<>(service.employeeIndex(), HttpStatus.OK);
//    }
//
//    //find by manager
//    @GetMapping("/{manager}")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Iterable<Employee>> showByManager(@PathVariable("manager") Employee manager) {
//        return new ResponseEntity<>(service.findByManager(manager), HttpStatus.OK);
//    }
//
//    //find no manager
//    @GetMapping("/noManager")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Iterable<Employee>> showNoManager() {
//        return new ResponseEntity<>(service.findNoManager(), HttpStatus.OK);
//    }
//
//    //find by dept
//    @GetMapping("/{deptNum}")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Iterable<Employee>> showByDept(@PathVariable("deptNum") Long deptNum) {
//        return new ResponseEntity<>(service.findByDept(deptNum), HttpStatus.OK);
//    }
//
//    //full employee update
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Employee> updateAll(@PathVariable("id") Long id, @RequestBody Employee employee) {
//        return new ResponseEntity<>(service.updateEmployee(id, employee), HttpStatus.OK);
//    }
//
//    //update manager
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Employee> updateManager(@PathVariable("id") Long id, @RequestBody Employee manager) {
//        return new ResponseEntity<>(service.updateManager(id, manager), HttpStatus.OK);
//    }
//
//    //delete employee
//    @DeleteMapping("/{id}")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Boolean> deleteOne(@PathVariable("id") Long id) {
//        return new ResponseEntity<>(service.deleteEmployee(id), HttpStatus.OK);
//    }
//
//    //delete by dept
//    @DeleteMapping("/{deptNum}")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Boolean> deleteByManager(@PathVariable("deptNum") Long deptNum) {
//        return new ResponseEntity<>(service.deleteByDept(deptNum), HttpStatus.OK);
//    }
//
//    //delete by manager
//    @DeleteMapping("/{manager}")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Boolean> deleteByManager(@PathVariable("manager") Employee manager) {
//        return new ResponseEntity<>(service.deleteByManager(manager), HttpStatus.OK);
//    }

}
