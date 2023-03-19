package com.joshguna.service;

import com.joshguna.dto.UserDTO;

//This class is used to remove code redundancy
public interface UserService extends CrudService<UserDTO, String> {

    //Extends everything in CrudService, also can have specific business logic
    //UserDTO myLogic(UserDTO userDTO);

}
