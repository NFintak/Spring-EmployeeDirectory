package io.zipcoder.controllers;

//import io.zipcoder.persistenceapp.config.WebConfig;
import io.zipcoder.persistenceapp.controllers.EmployeeController;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.EmployeeRepo;
import io.zipcoder.persistenceapp.PersistenceStarterApplication;
//import io.zipcoder.persistenceapp.services.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest (classes = EmployeeController.class)
//@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @MockBean
    private EmployeeRepo repo;

//    @Mock
//    private EmployeeService employeeService;

//    @InjectMocks
//    private EmployeeController employeeController;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testShowOne() throws Exception {
        String json = "{\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"title\":\"\"," +
                "\"phoneNum\":\"\",\"email\":\"\",\"hireDate\":null,\"manager\":null,\"deptNum\":0L}";

        mvc.perform(post("/API/employees/2L")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Jane"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$deptNum").value("0L"));
    }

//    @Test
//    public void testShowOne() throws Exception {
//        Long givenId = 1L;
//        BDDMockito
//                .given(repo.findOne(givenId))
//                .willReturn(new Employee("Jane", "Doe"));
//        String expectedContent = "{\"employeeId\":null,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"title\":\"\"," +
//                "\"phoneNum\":\"\",\"email\":\"\",\"hireDate\":null,\"manager\":null,\"deptNum\":0}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .get("/employees/" + givenId))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//    }

}
