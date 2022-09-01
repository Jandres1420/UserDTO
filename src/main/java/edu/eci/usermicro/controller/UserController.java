package edu.eci.usermicro.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
import org.springframework.web.bind.annotation.RestController;

import edu.eci.usermicro.dto.UserDto;
import edu.eci.usermicro.entities.*;
import edu.eci.usermicro.service.UserService;
import edu.eci.usermicro.service.impl.UserServiceImpl;

@RestController
public class UserController {
    private final AtomicLong counter = new AtomicLong();
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<User> allUsers = userService.getAll();
        return new ResponseEntity<List<UserDto>>(userService.fromEntityToDtos(allUsers), HttpStatus.ACCEPTED);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<UserDto> findById( @PathVariable String id ) {
        User user = userService.findById(id);
        System.out.println("usuario buscado "  + user.getName() + " id " + user.getId());
        return new ResponseEntity<UserDto>(userService.fromEntityToDto(user),HttpStatus.ACCEPTED);
    }


    @PostMapping()
    public ResponseEntity<UserDto> create( @RequestBody UserDto userDto ) {
        User user = userService.fromDtoToEntity(userDto);
        return new ResponseEntity<UserDto> (userService.fromEntityToDto(userService.create(user)),HttpStatus.ACCEPTED);
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<UserDto> update( @RequestBody UserDto user, @PathVariable String id ) {
        User userC = userService.fromDtoToEntity(user);
        userService.fromEntityToDto(userService.update(userC, id));
        return new ResponseEntity<UserDto>(userService.fromEntityToDto(userService.update(userC, id)),HttpStatus.ACCEPTED) ;
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        //TODO implement this method using UserService
        return null;      
    }
}

