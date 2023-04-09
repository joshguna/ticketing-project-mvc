package com.joshguna.converter;

import com.joshguna.dto.UserDTO;
import com.joshguna.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserConverter implements Converter<String, UserDTO> {

    UserService userService;

    public UserConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        return userService.findByID(source);
    }
}
