package com.projectspringbootdept.projectdept.controllers;

import com.projectspringbootdept.projectdept.entities.User;
import com.projectspringbootdept.projectdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users2")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){
        List<User> result = repository.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        User result = repository.findById(id).get();
        return result;
    }
    @PostMapping
    public User creat(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }
    @PutMapping
    public User upDate(@RequestBody User user) {
        User result = repository.save(user);
        return result;
    }
    @DeleteMapping(value = "/{id}")
    public Optional<User> delete(@PathVariable Long id){
        Optional<User> result = repository.findById(id);
        repository.deleteById(id);
        return result;
    }

}
