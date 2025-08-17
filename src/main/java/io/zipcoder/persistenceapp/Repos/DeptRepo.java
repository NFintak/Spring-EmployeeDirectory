package io.zipcoder.persistenceapp.Repos;

import io.zipcoder.persistenceapp.Models.Department;
//import io.zipcoder.persistenceapp.Models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface DeptRepo extends CrudRepository<Department, Integer> {
}
