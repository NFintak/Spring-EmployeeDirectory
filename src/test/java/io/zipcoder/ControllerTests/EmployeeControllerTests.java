package io.zipcoder.ControllerTests;

import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Repos.EmployeeRepo;
import io.zipcoder.persistenceapp.PersistenceStarterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

//@SpringBootTest
@ContextConfiguration(classes = PersistenceStarterApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeRepo repo;

    @Test
    public void testCreate() throws Exception {
        Employee test = new Employee("Jane", "Doe");
        BDDMockito.given(repo.save(test)).willReturn(test);
        String expectedContent = "{\"employeeId\":0,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"title\":\"\",\"email\":\"\"" +
                ",\"hireDate\":null,\"manager\":null,\"deptNum\":0,\"phoneNumber\":\"\"";
        this.mvc.perform(MockMvcRequestBuilders
                .post("/API/employees/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
