package tr.com.ege.se.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tr.com.ege.se.entity.ProjectPlan;
import tr.com.ege.se.entity.User;
import tr.com.ege.se.model.ProjectPlanDTO;
import tr.com.ege.se.model.UserDTO;
import tr.com.ege.se.service.ProjectPlanService;
import tr.com.ege.se.service.UserService;

@RestController
@RequestMapping("/api/projectplan")
public class ProjectPlanController {

	private ProjectPlanService projectPlanService;

	@Autowired
	public ProjectPlanController(ProjectPlanService projectPlanService) {
		this.projectPlanService = projectPlanService;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectPlanController.class);

	@PostMapping(value = "")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_EXECUTIVE') OR hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> post(@Valid @RequestBody ProjectPlanDTO projectPlanDTO) {
		ProjectPlan projectPlan = projectPlanService.save(projectPlanDTO);

		return ResponseEntity.ok(projectPlan);
	}
	

}
