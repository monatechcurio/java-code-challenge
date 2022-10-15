package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest {

    private String compensationUrl;

    private String employeeIdUrl;

    private String employeeUrl;

    @Autowired
    private CompensationService compensationService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        employeeUrl = "http://localhost:" + port + "/employee";
        compensationUrl = "http://localhost:" + port + "/compensation";
        employeeIdUrl = "http://localhost:" + port + "/compensation/findByEmployeeId/{id}";
    }

    @Test
    public void testCompensationCreateRead() {
        Employee employee = new Employee();
        employee.setFirstName("Max");
        employee.setLastName("Fury");
        employee.setDepartment("Engineering");
        employee.setPosition("Fresher");

        employee = restTemplate.postForEntity(employeeUrl, employee, Employee.class).getBody();

        Compensation compensation = new Compensation();
        compensation.setEmployee(employee);
        compensation.setEffectiveDate(Date.valueOf(LocalDate.now()));
        compensation.setSalary(75000);

        // Create check
        Compensation createdCompensation = restTemplate.postForEntity(compensationUrl, compensation, Compensation.class).getBody();
        assertNotNull(createdCompensation.getEffectiveDate());
        assertNotNull(createdCompensation.getSalary());

        // FindByEmployee check
        Compensation foundCompensation = restTemplate.getForEntity(employeeIdUrl, Compensation.class, createdCompensation.getEmployee().getEmployeeId()).getBody();
        assertNotNull(foundCompensation);
        assertEquals(foundCompensation.getEmployee().getEmployeeId(), createdCompensation.getEmployee().getEmployeeId());
        assertEquals(foundCompensation.getSalary(), createdCompensation.getSalary());

    }
}
