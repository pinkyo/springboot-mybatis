package my.pinkyo.demo.mapper;

import my.pinkyo.demo.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;

import my.pinkyo.demo.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
	@SelectProvider(type = UserSqlProvider.class, method = "getUserByName")
	User getUserByName(@Param("name") String name);

	@SelectProvider(type = UserSqlProvider.class, method = "getUsers")
	List<User> getUsers();
	
	@InsertProvider(type = UserSqlProvider.class, method = "saveUser")
	void saveUser(@Param("user") User user);

	@UpdateProvider(type = UserSqlProvider.class, method = "updateUser")
	void updateUser(@Param("user") User user);
}
