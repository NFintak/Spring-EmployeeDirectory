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

    public Iterable<Employee> index() {
        return repo.findAll();
    }

    public List<Employee> findByManager(Employee manager) {
        List<Employee> byManager = new ArrayList<>();
        for (Employee employee : index()) {
            if (manager.equals(employee.getManager())) {
                byManager.add(employee);
            }
        }
        return byManager;
    }

}
