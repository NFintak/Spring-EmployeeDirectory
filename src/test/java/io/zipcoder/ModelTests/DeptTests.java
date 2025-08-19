package io.zipcoder.ModelTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.Assert.*;
import org.junit.Test;
import javax.persistence.Entity;
import io.zipcoder.persistenceapp.Models.Department;
import io.zipcoder.persistenceapp.Models.Employee;

public class DeptTests {

    @Test
    public void testClassSignatureAnnotation() {
        assertTrue(Department.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testNullConstructor() {
        Department test = new Department();
        assertNotNull(test);
    }

    @Test
    public void test1Constructor() {
        Department test = new Department("Test", new Employee("Jane", "Doe"));
        assertNotNull(test);
        assertEquals("Test", test.getDeptName());
    }

    @Test
    public void testGetDeptId() {
        Department test = new Department();
        assertEquals(0, test.getDeptId());
    }

    @Test
    public void testGetSetDeptName() {
        Department test = new Department();
        String expectedName = "Human Resources";
        test.setDeptName(expectedName);
        assertEquals("Human Resources", test.getDeptName());
    }

    @Test
    public void testGetSetDeptManager() {
        Department test = new Department();
        Employee expected = new Employee();
        test.setDeptManager(expected);
        assertEquals(expected, test.getDeptManager());
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Employee manager = new Employee("Jane", "Doe");
        Department test = new Department("Human Resources", manager);
        String json = jsonWriter.writeValueAsString(test);
        String expected = "{\"deptId\":0,\"deptName\":\"Human Resources\",\"deptManager\":{\"employeeId\":0,\"firstName\":\"Jane\",\"lastName\":\"Doe\"," +
                "\"title\":\"\",\"email\":\"\",\"hireDate\":null,\"manager\":null,\"deptNum\":0,\"phoneNumber\":\"\"}}";
        assertEquals(expected, json);
    }

}
