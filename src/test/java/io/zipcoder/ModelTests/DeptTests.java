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

}
