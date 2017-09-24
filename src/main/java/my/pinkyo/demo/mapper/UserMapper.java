package my.pinkyo.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import my.pinkyo.demo.model.User;

@Mapper
public interface UserMapper {
	@Select("SELECT id, name, sex FROM user WHERE name=#{name}")
	User getUserByName(String name);
	
	@Insert("INSERT INTO user(name, sex) VALUES(#{name}, #{sex})")
	void saveUser(User user);
}
