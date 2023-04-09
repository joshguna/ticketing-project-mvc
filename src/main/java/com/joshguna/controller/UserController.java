package com.joshguna.controller;

import com.joshguna.dto.UserDTO;
import com.joshguna.service.RoleService;
import com.joshguna.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String insertUser(@ModelAttribute("user") UserDTO user, BindingResult bindingResult, Model model) {

        //When user is added, page needs an empty form. So we need new UserDTO
        //Otherwise form th:object will throw exception as it's bound to Java

        //saving to db
        userService.save(user);

        //if we redirect then no new DTO needed
        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model) {

        model.addAttribute("user", userService.findByID(username));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/update";

    }

    @PostMapping("/update")
    public String updateUser(UserDTO user) {

        userService.update(user);

        return "redirect:/user/create";
    }

}
