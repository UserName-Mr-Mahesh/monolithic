package com.jsp.services.service;

import com.jsp.services.entity.Project;

public interface ProjectService {
	public Project saveProduct(Project project);
	public Project getProjectByCode(long projectCode);
}
