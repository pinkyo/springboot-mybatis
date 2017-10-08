package my.pinkyo.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import my.pinkyo.demo.model.User;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
	@Select("SELECT id, name, sex FROM user WHERE name=#{name}")
	User getUserByName(String name);
	
	@Insert("INSERT INTO user(name, sex) VALUES(#{name}, #{sex})")
	void saveUser(User user);

	@Update("UPDATE user SET name=#{name}, sex=#{sex} where name=#{name}")
	void updateUser(User user);
}
