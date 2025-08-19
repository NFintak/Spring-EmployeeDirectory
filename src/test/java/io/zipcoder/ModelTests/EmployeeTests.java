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
        Employee test = new Employee();
        String expectedTitle = "Assistant Manager";
        test.setTitle(expectedTitle);
        assertEquals(expectedTitle, test.getTitle());
    }

    @Test
    public void testGetSetPhoneNum() {
        Employee test = new Employee();
        String expectedNum = "555-444-3322";
        test.setPhoneNumber(expectedNum);
        assertEquals(expectedNum, test.getPhoneNumber());
    }

    @Test
    public void testGetSetEmail() {
        Employee test = new Employee();
        String expectedEmail = "jdoe@test.com";
        test.setEmail(expectedEmail);
        assertEquals(expectedEmail, test.getEmail());
    }

    @Test
    public void testGetSetHireDate() {
        Employee test = new Employee();
        Date expectedDate = new Date(2017/4/23);
        test.setHireDate(expectedDate);
        assertEquals(expectedDate, test.getHireDate());
    }

    @Test
    public void testGetSetManager() {
        Employee test = new Employee();
        Employee expectedManager = new Employee("Jane", "Doe");
        test.setManager(expectedManager);
        assertEquals(expectedManager, test.getManager());
    }

    @Test
    public void testGetSetDeptNum() {
        Employee test = new Employee();
        int expectedDeptNum = 42;
        test.setDeptNum(expectedDeptNum);
        assertEquals(42, test.getDeptNum());
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Employee test = new Employee();
        String json = jsonWriter.writeValueAsString(test);
        String expected = "{\"employeeId\":0,\"firstName\":\"\",\"lastName\":\"\",\"title\":\"\",\"email\":\"\",\"hireDate\":null,\"manager\":null,\"deptNum\":0,\"phoneNumber\":\"\"}";
        assertEquals(expected, json);
    }
}
