package com.tec.anji.controller;

import com.tec.anji.bean.User;
import com.tec.anji.dao.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userRepository.getOne(id);
    }
}
