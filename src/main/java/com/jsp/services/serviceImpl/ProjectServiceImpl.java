package com.jsp.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.services.entity.Project;
import com.jsp.services.repository.ProjectRepository;
import com.jsp.services.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;
	@Override
	public Project saveProduct(Project project) {
		Project saveProject= projectRepository.save(project);
		return saveProject;
	}

	@Override
	public Project getProjectByCode(long projectCode) {
		Project foundProject= projectRepository.findByProjectCode(projectCode);
		return foundProject;
	}

}
