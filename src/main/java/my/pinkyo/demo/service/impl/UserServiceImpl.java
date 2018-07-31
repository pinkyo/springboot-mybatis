package my.pinkyo.demo.service.impl;

import com.github.pagehelper.PageHelper;
import my.pinkyo.demo.constant.Constant;
import my.pinkyo.demo.exception.BadRequestException;
import my.pinkyo.demo.mapper.UserMapper;
import my.pinkyo.demo.model.DataCategory;
import my.pinkyo.demo.model.User;
import my.pinkyo.demo.service.DumpService;
import my.pinkyo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService, DumpService<User> {
	@Autowired
	private UserMapper userMapper;

	@Transactional
	@Override
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

	@Override
	public User getByName(String name) {
		User result = userMapper.getUserByName(name);
		if (Objects.isNull(result)) {
			throw new BadRequestException(Constant.USER_NOT_FOUND);
		}

		return result;
	}

	@Override
	public List<User> getByPage(int startIndex, int pageSize) {
		PageHelper.offsetPage(startIndex, pageSize);
		return userMapper.getUsers();
	}

	@Transactional
	@Override
	public void updateUser(User user) {
		User result = userMapper.getUserByName(user.getName());
		if (Objects.isNull(result)) {
			throw new BadRequestException(Constant.USER_NOT_FOUND);
		}

		userMapper.updateUser(user);
	}

    @Override
    public List<User> dump() {
        return userMapper.getUsers();
    }

    @Override
    public DataCategory getCategory() {
        return DataCategory.USER;
    }
}
