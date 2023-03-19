package com.joshguna.controller;

import com.joshguna.dto.UserDTO;
import com.joshguna.service.RoleService;
import com.joshguna.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    //Injecting service to not use new keyword
    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "user/create";
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model) {

        //When user is added, page needs an empty form. So we need new UserDTO
        //Otherwise form th:object will throw exception as it's bound to Java
        //model.addAttribute("user", new UserDTO());
        //model.addAttribute("roles", roleService.findAll());
        //model.addAttribute("users", userService.findAll());

        //saving to db
        userService.save(user);

        //return "/user/create";
        //if we redirect then no new DTO needed
        return "redirect:/user/create";
    }

}
