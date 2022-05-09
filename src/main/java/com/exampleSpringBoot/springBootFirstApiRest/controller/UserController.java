package com.exampleSpringBoot.springBootFirstApiRest.controller;

import com.exampleSpringBoot.springBootFirstApiRest.dto.UserDto;
import com.exampleSpringBoot.springBootFirstApiRest.mappers.UserMapper;
import com.exampleSpringBoot.springBootFirstApiRest.model.User;
import com.exampleSpringBoot.springBootFirstApiRest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping()
    public ResponseEntity<UserDto> save(@RequestBody User user) {
        return new ResponseEntity<>(userMapper.modelToDto(userService.saveUser(user)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable("id") long id) {
        return new ResponseEntity<UserDto>(UserMapper.INSTANCE.modelToDto(userService.getUserById(id)), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<List<UserDto>>(userMapper.modelsToDtos(userService.getAllUsers()), HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") long id,
                                           @RequestBody User user) {
        return new ResponseEntity<UserDto>(userMapper.modelToDto(userService.updateUser(user, id)), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }

}
