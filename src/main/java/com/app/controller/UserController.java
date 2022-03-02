package com.app.controller;

import com.app.models.User;
import com.app.models.UserDTO;
import com.app.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public class UserController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserService userService;
    @GetMapping
    public ResponseEntity<Iterable<UserDTO>> findAllUser() {
        List<User> users=(List<User>) userService.findAll();
        List<UserDTO> userDTOs=users.stream().map(u -> modelMapper.map(u,UserDTO.class)).collect(Collectors.toList());
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User User) {
        userService.save(User);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
    @PatchMapping ("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User User) {
        Optional<User> optionalUser = userService.findById(id);
        if (!optionalUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User.setId(optionalUser.get().getId());
        userService.save(User);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.remove(id);
        return new ResponseEntity<>(userOptional.get(), HttpStatus.NO_CONTENT);
    }
}
