package com.example.useraccountmanagementbackend.controller;

import com.example.useraccountmanagementbackend.domain.User;
import com.example.useraccountmanagementbackend.security.jwt.JwtUtils;
import com.example.useraccountmanagementbackend.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author blaise
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
            return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<?> findUsers() {
        return new ResponseEntity<List<User>>(userService.findUsers(), HttpStatus.OK);
    }

    @GetMapping("/fetch/{username}")
    public ResponseEntity<?> fetchUser(@PathVariable String username) {
        return new ResponseEntity<User>(userService.fetchUser(username), HttpStatus.OK);
    }

    @PostMapping("/status")
    public ResponseEntity<?> changeStatus(@RequestBody User user) {
        return new ResponseEntity<User>(userService.changeStatus(user), HttpStatus.OK);
    }
}
