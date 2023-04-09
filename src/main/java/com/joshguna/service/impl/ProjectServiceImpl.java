package com.joshguna.service.impl;

import com.joshguna.dto.ProjectDTO;
import com.joshguna.dto.RoleDTO;
import com.joshguna.enums.Status;
import com.joshguna.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    @Override
    public ProjectDTO save(ProjectDTO object) {

        //Every new project status must be OPEN
        //Logic below converts new(null) into OPEN status
        if (object.getProjectStatus() == null) {
            object.setProjectStatus(Status.OPEN);
        }

        return super.save(object.getProjectCode(), object);
    }

    @Override
    public ProjectDTO findByID(String id) {
        return super.findByID(id);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {
        super.update(object.getProjectCode(), object);
    }

    @Override
    public void deleteByID(String id) {
        super.deleteByID(id);
    }
}
