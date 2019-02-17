package my.pinkyo.demo.mapper;

import my.pinkyo.demo.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

	User getUserByName(@Param("name") String name);

	List<User> getUsers();
	
	void saveUser(@Param("user") User user);

	void updateUser(@Param("user") User user);
}
