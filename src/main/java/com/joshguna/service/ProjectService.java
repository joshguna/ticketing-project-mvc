package com.joshguna.service;

import com.joshguna.dto.ProjectDTO;
import com.joshguna.dto.UserDTO;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO, String> {

    void complete(ProjectDTO project);

    List<ProjectDTO> findAllNonCompletedProjects();

    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);

}
