package io.zipcoder.ServiceTests;

import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Services.EmployeeService;
import io.zipcoder.persistenceapp.Controllers.EmployeeController;
import io.zipcoder.persistenceapp.Repos.EmployeeRepo;
import io.zipcoder.persistenceapp.PersistenceStarterApplication;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = PersistenceStarterApplication.class)
public class EmployeeServiceTests {

    @MockBean
    private EmployeeService service;

    @InjectMocks
    private EmployeeController controller;

//    @MockBean
//    private EmployeeRepo repo;

    @Before
    public void setUp() {
        //this.service = new EmployeeService(repo);
        this.controller = new EmployeeController(service);
    }

    @Test
    public void testCreateEmployee() {
        HttpStatus expected = HttpStatus.CREATED;
        Employee expectedEmployee = new Employee("Jane", "Doe");
        BDDMockito.given(service.create(expectedEmployee)).willReturn(expectedEmployee);
        ResponseEntity<Employee> response = controller.createEmployee(expectedEmployee);
        HttpStatus actual = response.getStatusCode();
        Employee actualEmployee = response.getBody();
        assertEquals(expected, actual);
        assertEquals(expectedEmployee, actualEmployee);
    }

}
