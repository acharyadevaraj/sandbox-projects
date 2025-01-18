package com.learning.springpagination.controller;

import com.learning.springpagination.entity.UserMaster;
import com.learning.springpagination.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/users")
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
    public ResponseEntity<List<UserMaster>> getUserList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") Sort.Direction sortOrder) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortOrder, "id"));
        List<UserMaster> userList = userService.getUserList(pageable).getContent();
        return ResponseEntity.ok(userList);
    }
}
