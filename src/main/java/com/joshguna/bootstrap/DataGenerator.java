package com.joshguna.bootstrap;

import com.joshguna.dto.RoleDTO;
import com.joshguna.dto.UserDTO;
import com.joshguna.enums.Gender;
import com.joshguna.service.RoleService;
import com.joshguna.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    //We autowire here because don't want to use new Keyword. Tightly couple way:
    //RoleServiceImpl r = new RoleServiceImpl();

    RoleService roleService;
    UserService userService;

    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
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

        UserDTO user1 = new UserDTO("Joshgun", "Admin", "joshgun@adm.com", "9991234567", "Abc123", Gender.Male, adminRole, true);
        UserDTO user2 = new UserDTO("Korvo", "Shlorp", "korvo@shlo.com", "5991230967", "Cbc123", Gender.Male, managerRole, true);
        UserDTO user3 = new UserDTO("Khang", "Terri", "khang@aga.com", "9998334447", "Ebc123", Gender.FEMALE, managerRole, true);
        UserDTO user4 = new UserDTO("Billy", "Lube", "billy@lube.com", "7691234567", "Rbc123", Gender.FEMALE, employeeRole, true);
        UserDTO user5 = new UserDTO("Gayn", "Grey", "gayn@grey.com", "6691234564", "Vbc123", Gender.FEMALE, employeeRole, true);
        UserDTO user6 = new UserDTO("Matt", "Chill", "chill@mau.com", "3491234562", "Zbc123", Gender.Male, employeeRole, false);
        UserDTO user7 = new UserDTO("Norris", "Adas", "norris@adas.com", "0991234587", "Xbc123", Gender.Male, employeeRole, false);
        UserDTO user8 = new UserDTO("Joe", "Lala", "joe@lala.com", "2791234957", "Pbc123", Gender.Male, employeeRole, true);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

    }
}
