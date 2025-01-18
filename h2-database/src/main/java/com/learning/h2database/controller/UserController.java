package com.learning.h2database.controller;

import com.learning.h2database.entity.UserMaster;
import com.learning.h2database.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/list")
    public ResponseEntity<List<UserMaster>> getUserList() {
        List<UserMaster> userList = userService.getUserList();
        return ResponseEntity.ok(userList);
    }
}
