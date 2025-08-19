package io.zipcoder.ServiceTests;

import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Services.EmployeeService;
import io.zipcoder.persistenceapp.Controllers.EmployeeController;
import io.zipcoder.persistenceapp.PersistenceStarterApplication;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceStarterApplication.class)
public class EmployeeServiceTests {

    @MockBean
    private EmployeeService service;

    private EmployeeController controller;


}
