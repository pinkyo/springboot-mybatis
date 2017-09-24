package my.pinkyo.demo.service;

import my.pinkyo.demo.mapper.UserMapper;
import my.pinkyo.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	@Transactional
	public boolean saveUser(User user) {
		User result = userMapper.getUserByName(user.getName());

		if (result == null) {
			userMapper.saveUser(user);
			return true;
		}

		return false;
	}
	
	public User getByName(String name) {
		User user = userMapper.getUserByName(name);
		return user;
	}
}
