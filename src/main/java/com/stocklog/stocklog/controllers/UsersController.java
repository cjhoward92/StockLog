package com.stocklog.stocklog.controllers;

import com.stocklog.stocklog.data.User;
import com.stocklog.stocklog.data.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserMapper userMapper;

    public UsersController(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable long id, Model model) {

        log.info("Looking up user {}", id);
        final User user = userMapper.selectUserById(id);
        log.info("Found {}", user);

        model.addAttribute("found", user != null);
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("username", user.getUsername());
            model.addAttribute("createdAt", user.getCreatedAt());
            model.addAttribute("lastLoginAt", user.getLastLoginAt());
        }

        return "user";
    }
}
