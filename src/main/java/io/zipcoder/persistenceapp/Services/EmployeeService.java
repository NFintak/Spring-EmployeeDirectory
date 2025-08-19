package io.zipcoder.persistenceapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Repos.EmployeeRepo;
import java.util.List;
import java.util.ArrayList;

@Service
@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public Employee create(Employee employee) {
        return repo.save(employee);
    }

    public Employee update(int id, Employee newEmployee) {
        Employee originalData = repo.findOne(id);
        if (originalData == null) {
            return repo.save(newEmployee);
        } else {
            originalData.setFirstName(newEmployee.getFirstName());
            originalData.setLastName(newEmployee.getLastName());
            originalData.setTitle(newEmployee.getTitle());
            originalData.setPhoneNumber(newEmployee.getPhoneNumber());
            originalData.setEmail(newEmployee.getPhoneNumber());
            originalData.setHireDate(newEmployee.getHireDate());
            originalData.setManager(newEmployee.getManager());
            originalData.setDeptNum(newEmployee.getDeptNum());
            return repo.save(originalData);
        }
    }

    public Employee getEmployee(int id) {
        return repo.findOne(id);
    }

    public Iterable<Employee> index() {
        return repo.findAll();
    }

    public List<Employee> findByManager(Employee manager) {
        List<Employee> byManager = new ArrayList<>();
        for (Employee employees : index()) {
            if (manager.equals(employees.getManager())) {
                byManager.add(employees);
            }
        }
        return byManager;
    }

    public List<Employee> findReptHierarchy(Employee employee) {
        List<Employee> reportingChain = new ArrayList<>();
        while (employee.getManager() != null) {
            reportingChain.add(employee.getManager());
            employee = employee.getManager();
        }
        return reportingChain;
    }

    public List<Employee> findNullManagers() {
        List<Employee> noManagers = new ArrayList<>();
        for (Employee employee : index()) {
            if (employee.getManager() == null) {
                noManagers.add(employee);
            }
        }
        return noManagers;
    }

    public List<Employee> findByDept(int deptNum) {
        List<Employee> byDept = new ArrayList<>();
        for (Employee employee : index()) {
            if (employee.getDeptNum() == deptNum) {
                byDept.add(employee);
            }
        }
        return byDept;
    }

}
