package com.stocklog.stocklog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public String welcome(@RequestParam(name="name", required=false, defaultValue="Friend") String name,
                          Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }

}
