package io.zipcoder.models;

import org.junit.Test;
import static org.junit.Assert.*;
import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;

public class DepartmentTests {

    @Test
    public void testNullConstruct() {
        Department test = new Department();
        assertNotNull(test);
    }

    @Test
    public void testNotNullConstruct() {
        Department test = new Department("Human Resources", new Employee());
        assertNotNull(test);
    }

    @Test
    public void testGetDeptId() {
        Department test = new Department();
        assertNotNull(test.getDeptId());
    }

    @Test
    public void testGetSetDeptName() {
        Department test = new Department();
        String expected = "R&D";
        assertEquals("", test.getDeptName());
        test.setDeptName(expected);
        assertEquals("R&D", test.getDeptName());
    }

    @Test
    public void testGetSetDeptManager() {
        Department test = new Department();
        Employee expected = new Employee();
        assertNull(test.getDeptManager());
        test.setDeptManager(expected);
        assertEquals(expected, test.getDeptManager());
    }

}
