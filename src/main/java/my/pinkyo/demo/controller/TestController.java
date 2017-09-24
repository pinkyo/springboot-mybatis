package my.pinkyo.demo.controller;

import my.pinkyo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import my.pinkyo.demo.model.User;

@RestController
@RequestMapping("test")
public class TestController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public User getById(@PathVariable String name) {
		return userService.getByName(name);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody User user) {
		userService.saveUser(user);
	}
}
