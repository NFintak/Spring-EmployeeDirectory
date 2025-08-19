package io.zipcoder.persistenceapp.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import io.zipcoder.persistenceapp.Repos.EmployeeRepo;
import io.zipcoder.persistenceapp.Services.EmployeeService;
import io.zipcoder.persistenceapp.Models.Employee;

//all endpoints should start with '/API'
/* should include endpoints to:
READ
- list of employees directly/indirectly reporting to a given manager (should be applicable to non-managers too)
DELETE
- remove specific employee/list of employees
- remove all employees by dept
- remove all employees by manager (including indirects)
- remove direct reports only (all indirects report to next manager in hierarchy)
 */
@RestController
@RequestMapping("/API/employees")
public class EmployeeController {

    private final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepo employeeRepo; //rework to replace uses of repo with service

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = new Employee(employee.getFirstName(), employee.getLastName());
        employeeService.create(newEmployee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> updateById(@PathVariable("id") int id, @RequestBody Employee employee) {
        Employee toUpdate = employeeService.update(id, employee);
        return new ResponseEntity<Employee>(toUpdate, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        Employee byId = employeeService.getEmployee(id);
        if (byId == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(byId, HttpStatus.OK);
    }

    @GetMapping("/{manager}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employee>> getByManager(@PathVariable Employee manager) {
        List<Employee> byManager = employeeService.findByManager(manager);
        if (byManager.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Employee>>(byManager, HttpStatus.OK);
    }

    @GetMapping("/reporting/{employee}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employee>> getReportingChain(@PathVariable Employee employee) {
        List<Employee> reportingChain = employeeService.findReptHierarchy(employee);
        if (reportingChain.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Employee>>(reportingChain, HttpStatus.OK);
    }

    @GetMapping("/manager/null")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employee>> getNullManagerList() {
        List<Employee> nullManagerList = employeeService.findNullManagers();
        if (nullManagerList.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Employee>>(nullManagerList, HttpStatus.OK);
    }

    @GetMapping("/dept/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employee>> getByDeptNum(@PathVariable int deptNum) {
        List<Employee> byDeptNum = employeeService.findByDept(deptNum);
        if (byDeptNum.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Employee>>(byDeptNum, HttpStatus.OK);
    }

}
