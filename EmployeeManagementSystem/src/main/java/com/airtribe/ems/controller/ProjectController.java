package com.airtribe.ems.controller;

import com.airtribe.ems.entity.Project;
import com.airtribe.ems.exception.ResourceNotFoundException;
import com.airtribe.ems.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/id")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.createProject(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) throws ResourceNotFoundException {
        return ResponseEntity.ok(projectService.updateProject(id, project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) throws ResourceNotFoundException {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
