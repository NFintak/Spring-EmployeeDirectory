package io.zipcoder.persistenceapp.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

//all endpoints should start with '/API'
/* should include endpoints to:
POST/CREATE
- create employee
UPDATE
- update employee fields (first/last name, title, phone number, email, manager, dept)
READ
- list of employees under a manager
- reporting hierarchy for an employee (their manager + their manager's manager, etc.)
- list of employees w/ no manager
- list of employees in a given dept
- list of employees directly/indirectly reporting to a given manager (should be applicable to non-managers too)
- get employee info (dept, title, etc.)
DELETE
- remove specific employee/list of employees
- remove all employees by dept
- remove all employees by manager (including indirects)
- remove direct reports only (all indirects report to next manager in hierarchy)
 */

public class EmployeeController {
}
