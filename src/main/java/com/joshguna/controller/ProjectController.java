package com.joshguna.controller;

import com.joshguna.dto.ProjectDTO;
import com.joshguna.service.ProjectService;
import com.joshguna.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("managers", userService.findManagers());
        model.addAttribute("projects", projectService.findAll());

        return "/project/create";
    }

    @PostMapping("/create")
    public String insertProject(ProjectDTO project) {

        projectService.save(project);

        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode) {

        projectService.deleteByID(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode) {

        projectService.complete(projectService.findByID(projectCode));
        return "redirect:/project/create";
    }

}
