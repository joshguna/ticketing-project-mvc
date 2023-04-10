package com.joshguna.service.impl;

import com.joshguna.dto.ProjectDTO;
import com.joshguna.dto.RoleDTO;
import com.joshguna.dto.TaskDTO;
import com.joshguna.dto.UserDTO;
import com.joshguna.enums.Status;
import com.joshguna.service.ProjectService;
import com.joshguna.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    private final TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

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

        //In the form we don't have field for status
        //We need to save status first, else we get null error
        //Line below keeps it and saves it

        //FindByID to find through db or map
        ProjectDTO project = findByID(object.getProjectCode());

        if (object.getProjectStatus() == null)
            object.setProjectStatus(project.getProjectStatus());
        super.update(object.getProjectCode(), object);


    }

    @Override
    public void deleteByID(String id) {
        super.deleteByID(id);
    }

    //method for completing projects
    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);

        //code below to save in db, map or elsewhere
        super.save(project.getProjectCode(), project);
    }

    @Override
    public List<ProjectDTO> findAllNonCompletedProjects() {
        return findAll().stream().filter(project -> !project.getProjectStatus().equals(Status.COMPLETE)).collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {

        List<ProjectDTO> projectList = findAll().stream()
                .filter(project -> project.getAssignedManager().equals(manager))
                .map(project -> {

                    List<TaskDTO> taskList = taskService.findTasksByManager(manager);
                    int completeTaskCounts = (int) taskList.stream()
                            .filter(t -> t.getProject().equals(project) && t.getTaskStatus() == Status.COMPLETE).count();

                    int unfinishedTaskCounts = (int) taskList.stream()
                            .filter(t -> t.getProject().equals(project) && t.getTaskStatus() != Status.COMPLETE).count();

                    project.setCompleteTaskCounts(completeTaskCounts);
                    project.setUnfinishedTaskCounts(unfinishedTaskCounts);

                    return project;
                }).collect(Collectors.toList());

        return projectList;
    }
}
