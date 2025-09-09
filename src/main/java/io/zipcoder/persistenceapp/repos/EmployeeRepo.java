package io.zipcoder.persistenceapp.repos;

import io.zipcoder.persistenceapp.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    Iterable<Employee> findByManager(Long managerId);
    Iterable<Employee> findNoManager();
    Iterable<Employee> findByDeptNum(Long deptNum);
}
