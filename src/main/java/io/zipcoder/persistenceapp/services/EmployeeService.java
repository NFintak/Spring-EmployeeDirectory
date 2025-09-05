package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

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
    public Iterable<Employee> findByManager(Employee manager) {
        ArrayList<Employee> byManager = new ArrayList<>();
        for (Employee employee : employeeIndex()) {
            if (employee.getManager().equals(manager)) {
                byManager.add(employee);
            }
        }
        return byManager;
    }

    //list of employees w no manager
    public Iterable<Employee> findNoManager() {
        ArrayList<Employee> noManager = new ArrayList<>();
        for (Employee employee : employeeIndex()) {
            if (employee.getManager() == null) {
                noManager.add(employee);
            }
        }
        return noManager;
    }

    //employees reporting hierarchy (their manager, their manager's manager, etc.)
    //employees by department
    public Iterable<Employee> findByDept(Long deptNum) {
        ArrayList<Employee> byDept = new ArrayList<>();
        for (Employee employee : employeeIndex()) {
            if (employee.getDeptNum().equals(deptNum)) {
                byDept.add(employee);
            }
        }
        return byDept;
    }

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

    public Boolean deleteEmployee(Long id) {
        repo.delete(id);
        return true;
    }

    //delete list of employees (by what criteria?)
    //delete by department
    //delete by manager (direct + indirect)
    //delete by manager (direct only)

}
