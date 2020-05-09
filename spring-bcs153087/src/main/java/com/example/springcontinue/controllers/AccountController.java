package com.example.springcontinue.controllers;

import com.example.springcontinue.entity.ApplicationUser;
import com.example.springcontinue.service.JavaUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JavaUtilService jwtUtil;

    @GetMapping
    public String login(@RequestBody ApplicationUser users) throws Exception {
        try {
            authenticationManager.authenticate {
                new UsernamePasswordAuthenticationToken( users.getUsername(), users.getPassword()
            }catch(Exception e){
                throw new Exception( "Invalid Credentials" );
            }return jwtUtil.generateToken( users.getUsername() );
        @PostMapping("/register")
        public String register(@RequestBody ApplicationUser user){
            userService.save(user);
            return new ResponseEntity<String>(body: "User CReated", HttpStatus,CREATED);
            }


        }
        }
    }