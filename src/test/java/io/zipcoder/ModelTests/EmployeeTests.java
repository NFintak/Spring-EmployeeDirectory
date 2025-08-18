package io.zipcoder.ModelTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.Assert.*;
import org.junit.Test;
import javax.persistence.Entity;
import io.zipcoder.persistenceapp.Models.Employee;
import java.util.Date;

public class EmployeeTests {

    @Test
    public void testClassSignatureAnnotation() {
        assertTrue(Employee.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testNullConstructor() {
        Employee test = new Employee();
        assertNotNull(test);
    }

    @Test
    public void test1Constructor() {
        Employee test = new Employee("Jane", "Doe");
        assertNotNull(test);
        assertEquals("Jane", test.getFirstName());
        assertEquals("Doe", test.getLastName());
    }

    @Test
    public void test2Constructor() {
        Employee test = new Employee("Jane", "Doe", "555-444-3322", "jdoe@test.com", new Date(2000/01/01));
        assertNotNull(test);
        assertEquals("555-444-3322", test.getPhoneNumber());
    }

    @Test
    public void test3Constructor() {
        Employee test = new Employee("Jane", "Doe", "Assistant Manager", "555-444-3322", "jdoe@test.com", new Date(2000/01/01), new Employee(), 12);
        assertNotNull(test);
        assertEquals(12, test.getDeptNum());
    }

    @Test
    public void testGetSetNames() {
        Employee test = new Employee();
        String expectedFirst = "John";
        String expectedLast = "Doe";
        test.setFirstName(expectedFirst);
        test.setLastName(expectedLast);
        assertEquals(expectedFirst, test.getFirstName());
        assertEquals(expectedLast, test.getLastName());
    }

    @Test
    public void testGetSetTitle() {

    }

    @Test
    public void testGetSetPhoneNum() {

    }

    @Test
    public void testGetSetEmail() {

    }

    @Test
    public void testGetSetHireDate() {

    }

    @Test
    public void testGetSetManager() {

    }

    @Test
    public void testGetSetDeptNum() {

    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Employee test = new Employee();
        String json = jsonWriter.writeValueAsString(test);
        String expected = "{\"employeeId\":0,\"firstName\":\"\",\"lastName\":\"\",\"title\":\"\",\"email\":\"\",\"hireDate\":null,\"manager\":null,\"deptNum\":0,\"phoneNumber\":0}";
        assertEquals(expected, json);
    }
}
