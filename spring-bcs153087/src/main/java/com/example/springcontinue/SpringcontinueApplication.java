package com.example.springcontinue;

import com.example.springcontinue.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringcontinueApplication {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @PostConstruct
    public void addUser(){
        if(userRepository.findUsername("niazi") == null){
            String pas = passwordEncoder.encode(rawpassword: "niazi");
            ApplicationUser user = new ApplicationUser(id:1 username:"niazi",password:"pas");
            UserRepository.save(user);

        }

    }

    public static void main(String[] args) {
        SpringApplication.run( SpringcontinueApplication.class, args );
    }

}
