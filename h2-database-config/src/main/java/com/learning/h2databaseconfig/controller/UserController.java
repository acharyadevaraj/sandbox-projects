package com.learning.h2databaseconfig.controller;

import com.learning.h2databaseconfig.entity.UserMaster;
import com.learning.h2databaseconfig.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserMaster user) {
        UserMaster userData = null;

        try {
            userData = userService.saveUser(user);
            return ResponseEntity.ok("User Data Saved successfully");
        } catch (Exception e) {
            log.error("Error saving user data: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed To Save User Data.");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserMaster>> getUserList() {
        List<UserMaster> userList = userService.getUserList();
        return ResponseEntity.ok(userList);
    }
}
