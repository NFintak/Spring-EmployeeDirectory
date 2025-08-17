package io.zipcoder.persistenceapp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    private String firstName;
    private String lastName;
    private String title;
    private int phoneNum;
    private String email;
    private Date hireDate;
    private String manager;
    private int deptNum;

}
