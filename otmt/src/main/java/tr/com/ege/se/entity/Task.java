package tr.com.ege.se.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task extends EntityBase  {

	@Column(name = "TASKNAME", length = 255, unique = false)
	private String taskName;
	
	@Column(name = "ASSIGNEDTO", length = 255, unique = false)
	private String assignedTo;
	
	@Column(name = "STARTDATE")
	private Date startDate;

	@Column(name = "DUEDATE")
	private Date dueDate;
	
	@ManyToOne
	private ProjectPlan projectPlan;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public ProjectPlan getProjectPlan() {
		return projectPlan;
	}

	public void setProjectPlan(ProjectPlan projectPlan) {
		this.projectPlan = projectPlan;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	
}
