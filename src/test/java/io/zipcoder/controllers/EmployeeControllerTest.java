package io.zipcoder.controllers;

//import io.zipcoder.persistenceapp.config.WebConfig;
//import io.zipcoder.persistenceapp.services.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest (classes = EmployeeControllerTest.class)
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testCreate() throws Exception {
        String json = "{\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"title\":\"Intern\"" +
                ",\"phoneNum\":\"555-555-5555\",\"email\":\"test@test.com\",\"hireDate\":\"2000/9/20\"}";

        mvc.perform(post("/API/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Jane"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.title").value("Intern"));
    }

    @Test
    public void testShowOne() throws Exception {
        String json = "{\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"title\":\"\"," +
                "\"phoneNum\":\"\",\"email\":\"\",\"hireDate\":null,\"manager\":null,\"deptNum\":0L}";

        String response = mvc.perform(post("/API/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        Long employeeId = com.jayway.jsonpath.JsonPath.read(response, "$.employeeId");

        mvc.perform(post("/API/employees/" + employeeId + "/info")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Jane"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$deptNum").value("0L"));
    }

}
