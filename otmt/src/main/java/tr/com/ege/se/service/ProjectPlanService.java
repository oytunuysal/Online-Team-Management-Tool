package tr.com.ege.se.service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.ege.se.entity.ProjectPlan;
import tr.com.ege.se.entity.Task;
import tr.com.ege.se.entity.User;
import tr.com.ege.se.model.ProjectPlanDTO;
import tr.com.ege.se.model.UserDTO;
import tr.com.ege.se.repo.ProjectPlanRepository;
import tr.com.ege.se.repo.TaskRepository;
import tr.com.ege.se.repo.UserRepository;

@Service
public class ProjectPlanService {

	@Autowired
	private ProjectPlanRepository projectPlanRepository;
	
	@Autowired
	private TaskRepository taskRepository;

	public ProjectPlan save(ProjectPlanDTO projectPlanDTO) {
		ProjectPlan projectPlan = new ProjectPlan();
		projectPlan.setProjectName(projectPlanDTO.getProjectName());
		projectPlan.setTeamName(projectPlanDTO.getTeamName());
		projectPlan.setProjectManager(projectPlanDTO.getProjectManager());
		projectPlan.setStartDate(projectPlanDTO.getStartDate());
		projectPlan.setDueDate(projectPlanDTO.getDueDate());
		projectPlan.setTasks(projectPlanDTO.getTasks());
		
		ProjectPlan savedProjectPlan = projectPlanRepository.save(projectPlan);

		return savedProjectPlan;
	}
}
