package tr.com.ege.se.model;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;
import tr.com.ege.se.entity.Task;

public class ProjectPlanDTO {
	@NotBlank
	private String projectName;
	@NotBlank
	private String teamName;
	@NotBlank
	private String projectManager;
	
	private Date startDate;
	
	private Date dueDate;
	
	private List<Task> tasks;
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
}
