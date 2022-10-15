package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);
    @Autowired
    CompensationService compensationService;

    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received compensation create request for [{}]", compensation);
        Compensation savedCompensation = compensationService.create(compensation);
        return savedCompensation;
    }

    @GetMapping("/compensation/findByEmployeeId/{employeeId}")
    public Compensation findByEmployeeId(@PathVariable String employeeId) {
        LOG.debug("Received compensation fetch request for employeeId [{}]", employeeId);
        Compensation compensation = compensationService.findByEmployeeId(employeeId);
        return compensation;
    }
}
