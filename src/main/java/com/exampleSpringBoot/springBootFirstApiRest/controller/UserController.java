package com.exampleSpringBoot.springBootFirstApiRest.controller;

import com.exampleSpringBoot.springBootFirstApiRest.model.User;
import com.exampleSpringBoot.springBootFirstApiRest.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") long id){
        return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<User>> getAll(){
    	return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id,
    										@RequestBody User user){
    	return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
    	userService.deleteUser(id);
    	return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }
    
}
