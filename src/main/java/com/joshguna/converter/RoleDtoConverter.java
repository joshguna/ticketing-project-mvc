package com.joshguna.converter;

import com.joshguna.dto.RoleDTO;
import com.joshguna.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDtoConverter implements Converter<String, RoleDTO> {

    //This class is created for converting String from HTML in RoleDTO
    RoleService roleService;

    public RoleDtoConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {
        return roleService.findByID(Long.parseLong(source));
    }


}
