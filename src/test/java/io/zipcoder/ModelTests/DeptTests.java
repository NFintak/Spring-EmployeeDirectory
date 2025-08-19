package io.zipcoder.ModelTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.Assert.*;
import org.junit.Test;
import javax.persistence.Entity;
import io.zipcoder.persistenceapp.Models.Department;

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

}
