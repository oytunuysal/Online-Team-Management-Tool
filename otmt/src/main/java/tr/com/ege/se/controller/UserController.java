package tr.com.ege.se.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import tr.com.ege.se.entity.Book;
import tr.com.ege.se.entity.User;
import tr.com.ege.se.model.UserDTO;
import tr.com.ege.se.service.UserService;

import javax.validation.Valid;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@GetMapping("")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_EXECUTIVE')")
	public ResponseEntity<?> get(@RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
			@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {
		return ResponseEntity.ok(userService.findAll(pageSize, pageNumber));
	}

	@GetMapping("/{id}")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> get(@PathVariable long id) {
		Optional<User> userOptional = userService.findById(id);
		if (userOptional.isPresent()) {
			return ResponseEntity.ok(userOptional.get());
		}
		throw new IllegalArgumentException("User not found");
	}


	@GetMapping("/search")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> get(@RequestParam(name = "username", defaultValue = "") String username) {
		Optional<User> user = userService.findByUsername(username);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/searchusername")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getUsernames(@RequestParam(name = "username", defaultValue = "") String username) {
		List<User> userList = userService.findLikeUsernames(username);
		return ResponseEntity.ok(userList);
	}

	@GetMapping("/has-role-user")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> findByRoles() {
		List<User> userList = userService.findByRoles(Arrays.asList("ROLE_USER"));
		return ResponseEntity.ok(userList);
	}


	@DeleteMapping("/{id}")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> delete(@PathVariable long id) {
		User user = userService.delete(id);
		return ResponseEntity.ok(user);
	}

	@PostMapping(value = "")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> post(@Valid @RequestBody UserDTO userDTO) {
		User user = userService.save(userDTO);

		return ResponseEntity.ok(user);
	}

	@PostMapping("/activate/{id}")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> activate(@PathVariable long id) {
		User user = userService.activate(id);
		return ResponseEntity.ok(user);
	}

}
