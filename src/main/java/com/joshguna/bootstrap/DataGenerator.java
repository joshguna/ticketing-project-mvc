package com.joshguna.bootstrap;

import com.joshguna.dto.ProjectDTO;
import com.joshguna.dto.RoleDTO;
import com.joshguna.dto.TaskDTO;
import com.joshguna.dto.UserDTO;
import com.joshguna.enums.Gender;
import com.joshguna.enums.Status;
import com.joshguna.service.ProjectService;
import com.joshguna.service.RoleService;
import com.joshguna.service.TaskService;
import com.joshguna.service.UserService;
import org.apache.catalina.Store;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    //We autowire here because don't want to use new Keyword. Tightly couple way:
    //RoleServiceImpl r = new RoleServiceImpl();

    RoleService roleService;
    UserService userService;
    ProjectService projectService;
    TaskService taskService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService, TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {

        //Anything in this block will be executed first
        //Role DTOs
        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("Joshgun", "Admin", "joshgun@adm.com", "9991234567", "Abc123", Gender.MALE, adminRole, true);
        UserDTO user2 = new UserDTO("Korvo", "Shlorp", "korvo@shlo.com", "5991230967", "Cbc123", Gender.MALE, managerRole, true);
        UserDTO user3 = new UserDTO("Khang", "Terri", "khang@aga.com", "9998334447", "Ebc123", Gender.MALE, managerRole, true);
        UserDTO user4 = new UserDTO("Billy", "Lube", "billy@lube.com", "7691234567", "Rbc123", Gender.FEMALE, employeeRole, true);
        UserDTO user5 = new UserDTO("Gayn", "Grey", "gayn@grey.com", "6691234564", "Vbc123", Gender.FEMALE, employeeRole, true);
        UserDTO user6 = new UserDTO("Matt", "Chill", "chill@mau.com", "3491234562", "Zbc123", Gender.MALE, employeeRole, false);
        UserDTO user7 = new UserDTO("Norres", "Adas", "norris@adas.com", "0991234587", "Xbc123", Gender.FEMALE, employeeRole, false);
        UserDTO user8 = new UserDTO("Joe", "Lala", "joe@lala.com", "2791234957", "Pbc123", Gender.MALE, employeeRole, true);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

        ProjectDTO project1 = new ProjectDTO("Spring MVC", "P001", user2, LocalDate.now(), LocalDate.now().plusDays(20), "MVC Proj", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM", "P002", user2, LocalDate.now(), LocalDate.now().plusDays(12), "ORM Proj", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container", "P003", user3, LocalDate.now(), LocalDate.now().plusDays(45), "Container Proj", Status.COMPLETE);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);

        TaskDTO task1 = new TaskDTO(project1, user8, "Controller", "Request Mapping", Status.IN_PROGRESS, LocalDate.now().minusDays(4));
        TaskDTO task2 = new TaskDTO(project3, user3, "Configuration", "Database Connection", Status.COMPLETE, LocalDate.now().minusDays(12));
        TaskDTO task3 = new TaskDTO(project3, user6, "Mapping", "One-To-Many", Status.COMPLETE, LocalDate.now().minusDays(8));
        TaskDTO task4 = new TaskDTO(project2, user7, "Dependency Injection", "Autowired", Status.IN_PROGRESS, LocalDate.now().minusDays(20));

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
        taskService.save(task4);

    }
}
