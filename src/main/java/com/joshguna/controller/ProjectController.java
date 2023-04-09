package com.joshguna.controller;

import com.joshguna.dto.ProjectDTO;
import com.joshguna.service.ProjectService;
import com.joshguna.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    ProjectService projectService;
    UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model) {

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("managers", userService.findAll());
        model.addAttribute("projects", projectService.findAll());

        return "/project/create";
    }
}
