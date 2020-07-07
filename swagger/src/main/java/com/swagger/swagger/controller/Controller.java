package com.swagger.swagger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.swagger.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
@Api(value = "User API", description = "User API")
public class Controller {

	List<User> usersList = new ArrayList<User>();

	@ApiOperation("Returns the user based on id")
	@ApiResponses(value = { @ApiResponse(code = 100, message = "test Response") })
	@GetMapping
	public User getUser(@RequestParam("id") Integer id) {
		return usersList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
	}

	@ApiOperation("Creates New User")
	@PostMapping
	public Boolean createUser(@RequestBody User user) {
		return usersList.add(user);
	}

	@ApiOperation("Updates the existing user")
	@PutMapping
	public Boolean updateUser(@RequestBody User user) {

		User oldUser = usersList.stream().filter(p -> p.getId().equals(user.getId())).findFirst().orElse(null);
		if (oldUser != null) {
			oldUser.setName(user.getName());
			return true;
		} else {
			return false;
		}
	}

}
