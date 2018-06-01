package my.pinkyo.demo.mapper;

import my.pinkyo.demo.provider.UserSqlProvider;
import my.pinkyo.demo.typehandler.UUIDTypeHandler;
import org.apache.ibatis.annotations.*;

import my.pinkyo.demo.model.User;
import org.apache.ibatis.type.EnumTypeHandler;

import java.util.List;
import java.util.UUID;

@Mapper
public interface UserMapper {
    @Results(id = "getUserByName", value = {
            @Result(id = true, property = "id", column = "id", typeHandler = UUIDTypeHandler.class),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex", typeHandler = EnumTypeHandler.class)
    })
	@SelectProvider(type = UserSqlProvider.class, method = "getUserByName")
	User getUserByName(@Param("name") String name);

	@SelectProvider(type = UserSqlProvider.class, method = "getUsers")
	List<User> getUsers();
	
	@InsertProvider(type = UserSqlProvider.class, method = "saveUser")
	void saveUser(@Param("user") User user);

	@UpdateProvider(type = UserSqlProvider.class, method = "updateUser")
	void updateUser(@Param("user") User user);
}
