package tr.com.ege.se.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECTPLAN")
public class ProjectPlan extends EntityBase {

	@Column(name = "PROJECTNAME", length = 255, unique = true)
	private String projectName;

	@Column(name = "TEAMNAME", length = 255)
	private String teamName;

	@Column(name = "START_DATE")
	private Date startDate;


	@Column(name = "DUE_DATE")
	private Date dueDate;

	@Column(name = "PMANAGER", length = 255)
	private String projectManager;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Task> tasks;

	public String getProjectName() {
		return projectName;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
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
