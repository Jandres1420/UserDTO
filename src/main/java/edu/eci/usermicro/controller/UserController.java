package edu.eci.usermicro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.eci.usermicro.dto.UserDto;
import edu.eci.usermicro.entities.*;
import edu.eci.usermicro.service.UserService;
import edu.eci.usermicro.service.impl.UserServiceImpl;

@Controller
public class UserController {
    
    
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<User> allusers = userService.getAll();
        return new ResponseEntity<List<UserDto>>(allusers, HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<UserDto> findById( @PathVariable String id ) {
        
        return new ResponseEntity<UserDTO>(userService.findById(id),HttpStatus.ACCEPTED);
    }


    @PostMapping
    public ResponseEntity<UserDto> create( @RequestBody UserDto userDto ) {
        //TODO implement this method using UserService
        return null;
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<UserDto> update( @RequestBody UserDto user, @PathVariable String id ) {
        //TODO implement this method using UserService
        return null;
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        //TODO implement this method using UserService
        return null;      
    }
}

