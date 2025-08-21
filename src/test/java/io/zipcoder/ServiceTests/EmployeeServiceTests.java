package io.zipcoder.ServiceTests;

import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Services.EmployeeService;
import io.zipcoder.persistenceapp.Controllers.EmployeeController;
import io.zipcoder.persistenceapp.PersistenceStarterApplication;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceStarterApplication.class)
//@SpringBootTest(classes = PersistenceStarterApplication.class)
public class EmployeeServiceTests {

    @MockBean
    private EmployeeService service;

    private EmployeeController controller;

    @Before
    public void setUp() {
        this.controller = new EmployeeController(service);
    }

    @Test
    public void testCreateEmployee() {
        //given
        HttpStatus expected = HttpStatus.CREATED;
        Employee expectedEmployee = new Employee("Jane", "Doe");
        BDDMockito.given(service.create(expectedEmployee)).willReturn(expectedEmployee);
        //when
        ResponseEntity<Employee> response = controller.createEmployee(expectedEmployee);
        HttpStatus actual = response.getStatusCode();
        Employee actualEmployee = response.getBody();
        //then
        assertEquals(expected, actual);
        assertEquals(expectedEmployee, actualEmployee);
    }

}
