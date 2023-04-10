package com.joshguna.service.impl;

import com.joshguna.dto.TaskDTO;
import com.joshguna.dto.UserDTO;
import com.joshguna.enums.Status;
import com.joshguna.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO object) {

        if (object.getTaskStatus() == null) {
            object.setTaskStatus(Status.OPEN);
        }

        if (object.getAssignedDate() == null) {
            object.setAssignedDate(LocalDate.now());
        }

        if (object.getId() == null) {
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }

        return super.save(object.getId(), object);

    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaskDTO object) {

        TaskDTO foundTask = findByID(object.getId());

        object.setTaskStatus(foundTask.getTaskStatus());
        object.setAssignedDate(foundTask.getAssignedDate());

        super.update(object.getId(), object);

    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public TaskDTO findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public List<TaskDTO> findTasksByManager(UserDTO manager) {
        return findAll().stream().filter(task -> task.getProject().getAssignedManager().equals(manager)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllTasksByStatus(Status status) {
        return findAll().stream().filter(task -> task.getTaskStatus().equals(Status.COMPLETE)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllTasksByStatusIsNot(Status status) {
        return findAll().stream().filter(task -> !task.getTaskStatus().equals(Status.COMPLETE)).collect(Collectors.toList());
    }

    @Override
    public void updateStatus(TaskDTO task) {
        findByID(task.getId()).setTaskStatus(task.getTaskStatus());
        update(task);
    }

}