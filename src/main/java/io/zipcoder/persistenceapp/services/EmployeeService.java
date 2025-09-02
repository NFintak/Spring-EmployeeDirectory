package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public Employee employeeById(Long id) {
        return repo.findOne(id);
    }

    public Iterable<Employee> employeeIndex() {
        return repo.findAll();
    }

    //list of employees under particular manager
    //list of employees w no manager
    //employees reporting hierarchy (their manager, their manager's manager, etc.)
    //employees by department
    //all employees reporting to a specific manager (direct + indirect)

    //get dept, title, etc of employee

    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee original = repo.findOne(id);
        original.setFirstName(employee.getFirstName());
        original.setLastName(employee.getLastName());
        original.setTitle(employee.getTitle());
        original.setPhoneNum(employee.getPhoneNum());
        original.setEmail(employee.getEmail());
        original.setHireDate(employee.getHireDate());
        original.setManager(employee.getManager());
        original.setDeptNum(employee.getDeptNum());
        return repo.save(original);
    }

    public Employee updateManager(Long id, Employee manager) {
        Employee toUpdate = repo.findOne(id);
        toUpdate.setManager(manager);
        return repo.save(toUpdate);
    }

    public void deleteEmployee(Long id) {
        repo.delete(id);
    }

    //delete list of employees (by what criteria?)
    //delete by department
    //delete by manager (direct + indirect)
    //delete by manager (direct only)

}
