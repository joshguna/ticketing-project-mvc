package com.joshguna.service.impl;

import com.joshguna.dto.UserDTO;
import com.joshguna.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {

    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(), object);
    }

    @Override
    public UserDTO findByID(String id) {
        return super.findByID(id);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(String id) {
        super.deleteByID(id);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(), object);
    }

    //Code below added for listing managers in Project Creation page
    //2 means manager
    @Override
    public List<UserDTO> findManagers() {
        return super.findAll().stream()
                .filter(userDTO -> userDTO.getRole().getId() == 2)
                .collect(Collectors.toList());
    }
}
