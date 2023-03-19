package com.joshguna.dto;

import com.joshguna.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private String userName;
    private String phone;
    private String password;
    private Gender gender;
    private RoleDTO role;
    private boolean enabled;

}
