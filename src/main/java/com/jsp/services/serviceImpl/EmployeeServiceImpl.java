package com.jsp.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.services.entity.Employee;
import com.jsp.services.entity.Project;
import com.jsp.services.payload.EmployeeDto;
import com.jsp.services.repository.EmployeeRepository;
import com.jsp.services.repository.ProjectRepository;
import com.jsp.services.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Override
	public EmployeeDto saveEmployee(Employee employee) {
		Employee saveEmployee=employeeRepository.save(employee);
		Project project=projectRepository.findByProjectCode(saveEmployee.getEmployeeAssignedProject());
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setId(saveEmployee.getId());
		employeeDto.setEmployeeName(saveEmployee.getEmployeeName());
		employeeDto.setEmployeeEmail(saveEmployee.getEmployeeEmail());
		employeeDto.setEmployeeBaseLocation(saveEmployee.getEmployeeBaseLocation());
		employeeDto.setProjectCode(project.getProjectCode());
		employeeDto.setProjectName(project.getProjectName());
		return employeeDto;
	}
	@Override
	public EmployeeDto getEmlpoyeeById(long id) {
		Employee foundEmployee = employeeRepository.findById(id).get();
		Project project=projectRepository.findByProjectCode(foundEmployee.getEmployeeAssignedProject());
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setId(foundEmployee.getId());
		employeeDto.setEmployeeName(foundEmployee.getEmployeeName());
		employeeDto.setEmployeeEmail(foundEmployee.getEmployeeEmail());
		employeeDto.setEmployeeBaseLocation(foundEmployee.getEmployeeBaseLocation());
		employeeDto.setProjectCode(project.getProjectCode());
		employeeDto.setProjectName(project.getProjectName());
		return employeeDto;
	}

}
