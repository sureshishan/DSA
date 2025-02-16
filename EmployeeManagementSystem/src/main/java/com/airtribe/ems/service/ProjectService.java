package com.airtribe.ems.service;

import com.airtribe.ems.entity.Project;
import com.airtribe.ems.exception.ResourceNotFoundException;
import com.airtribe.ems.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) throws ResourceNotFoundException {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id{}" + id));
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project updatedProject) throws ResourceNotFoundException {
        Project existingProject = getProjectById(id);
        existingProject.setName(updatedProject.getName());
        existingProject.setBudget(updatedProject.getBudget());
        return projectRepository.save(existingProject);
    }

    public void deleteProject(Long id) throws ResourceNotFoundException {
        Project project = getProjectById(id);
        projectRepository.delete(project);
    }
}
