package my.pinkyo.demo.controller;

import my.pinkyo.demo.audit.AuditActionType;
import my.pinkyo.demo.audit.RestApiAudit;
import my.pinkyo.demo.service.UserService;
import my.pinkyo.demo.valiation.Insert;
import my.pinkyo.demo.valiation.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import my.pinkyo.demo.model.User;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
	private static final String DEFAULT_START_INDEX = "0";
	private static final String DEFAULT_PAGE_SIZE = "10";
	private static final String TEST_INFO = "Test";
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public User getByName(@PathVariable String name) {
		return userService.getByName(name);
	}

	@RequestMapping("")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getByPage(
			@RequestParam(value = "startIndex", required = false, defaultValue = DEFAULT_START_INDEX) int startIndex,
			@RequestParam(value = "pageSize", required = false, defaultValue = DEFAULT_PAGE_SIZE) int pageSize) {
		return userService.getByPage(startIndex, pageSize);
	}

	@RestApiAudit(AuditActionType.SAVE)
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@Validated({Insert.class}) @RequestBody User user) {
		return userService.saveUser(user);
	}

	@RestApiAudit(AuditActionType.UPDATE)
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateUser(@Validated({Update.class}) @RequestBody User user) {
		userService.updateUser(user);
	}

	@RestApiAudit(AuditActionType.INFO)
	@RequestMapping(value = "/info")
	@ResponseStatus(HttpStatus.OK)
	public String getInfo() {
		return TEST_INFO;
	}
}
