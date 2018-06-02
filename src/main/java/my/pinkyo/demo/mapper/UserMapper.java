package my.pinkyo.demo.mapper;

import my.pinkyo.demo.model.User;
import my.pinkyo.demo.provider.UserSqlProvider;
import my.pinkyo.demo.typehandler.UUIDTypeHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.EnumTypeHandler;

import java.util.List;

@Mapper
public interface UserMapper {
    @Results(id = "userResult", value = {
            @Result(id = true, property = "id", column = "id", typeHandler = UUIDTypeHandler.class),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex", typeHandler = EnumTypeHandler.class)
    })
	@SelectProvider(type = UserSqlProvider.class, method = "getUserByName")
	User getUserByName(@Param("name") String name);

    @ResultMap("userResult")
	@SelectProvider(type = UserSqlProvider.class, method = "getUsers")
	List<User> getUsers();
	
	@InsertProvider(type = UserSqlProvider.class, method = "saveUser")
	void saveUser(@Param("user") User user);

	@UpdateProvider(type = UserSqlProvider.class, method = "updateUser")
	void updateUser(@Param("user") User user);
}
