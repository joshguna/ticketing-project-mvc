package com.joshguna.entity;

import com.joshguna.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String phone;
    private String password;
    private Gender gender;
    private Role role;
    private boolean enabled;

    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime,
                Long lastUpdateUserId, String firstName, String lastName, String userName, String phone,
                String password, Gender gender, Role role, boolean enabled) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phone = phone;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.enabled = enabled;
    }
}
