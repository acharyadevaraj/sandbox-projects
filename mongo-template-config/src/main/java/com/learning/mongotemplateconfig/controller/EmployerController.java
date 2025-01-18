package com.learning.mongotemplateconfig.controller;

import com.learning.mongotemplateconfig.dto.EmployerResponse;
import com.learning.mongotemplateconfig.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employers")
public class EmployerController {

    private final EmployerService employerService;

    @GetMapping
    public ResponseEntity<List<EmployerResponse>> getAllEmployers() {
        List<EmployerResponse> employers = employerService.getAllEmployers();
        return new ResponseEntity<>(employers, HttpStatus.OK);
    }
}
