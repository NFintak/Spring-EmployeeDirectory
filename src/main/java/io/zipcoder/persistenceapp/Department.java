package io.zipcoder.persistenceapp;

import javax.persistence.*;
import io.zipcoder.persistenceapp.Employee;

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptId;
    private String deptName;
    private Employee deptManager;

}
