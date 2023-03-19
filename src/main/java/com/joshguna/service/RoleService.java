package com.joshguna.service;

import com.joshguna.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    RoleDTO save(RoleDTO role);

    RoleDTO findByID(Long id);

    List<RoleDTO> findAll();

    void delete(RoleDTO role);

    void deleteByID(Long id);

}
