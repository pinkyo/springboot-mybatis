package my.pinkyo.demo.service;

import com.github.pagehelper.PageHelper;
import my.pinkyo.demo.mapper.UserMapper;
import my.pinkyo.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	@Transactional
	public User saveUser(User user) {
		User result = userMapper.getUserByName(user.getName());
		if (result == null) {
			user.setId(UUID.randomUUID());
			userMapper.saveUser(user);
		} else {
			throw new RuntimeException("user have existed.");
		}
		return user;
	}
	
	public User getByName(String name) {
		return userMapper.getUserByName(name);
	}

	public List<User> getByPage(int startIndex, int pageSize) {
		PageHelper.offsetPage(startIndex, pageSize);
		return userMapper.getUsers();
	}

	@Transactional
	public void updateUser(User user) {
		User result = userMapper.getUserByName(user.getName());
		if (result == null) {
			throw new RuntimeException("user doesn't exist.");
		}

		userMapper.updateUser(user);
	}
}
