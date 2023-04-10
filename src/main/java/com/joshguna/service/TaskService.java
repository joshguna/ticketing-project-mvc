package com.joshguna.service;


import com.joshguna.dto.TaskDTO;
import com.joshguna.dto.UserDTO;
import com.joshguna.enums.Status;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long> {

    List<TaskDTO> findTasksByManager(UserDTO manager);

    List<TaskDTO> findAllTasksByStatus(Status status);

    List<TaskDTO> findAllTasksByStatusIsNot(Status status);

    void updateStatus(TaskDTO task);

}