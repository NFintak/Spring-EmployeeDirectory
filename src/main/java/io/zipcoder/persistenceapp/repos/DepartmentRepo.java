package io.zipcoder.persistenceapp.repos;

import io.zipcoder.persistenceapp.models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepo extends CrudRepository<Department, Long> {
}
