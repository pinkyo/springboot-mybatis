package my.pinkyo.demo.provider;

import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {
    public String getUserByName() {
        return new SQL(){{
            SELECT("id, name, sex");
            FROM("user");
            WHERE("name=#{name}");
        }}.toString();
    }

    public String getUsers() {
        return new SQL(){{
            SELECT("id, name, sex");
            FROM("user");
        }}.toString();
    }

    public String saveUser() {
        return new SQL(){{
            INSERT_INTO("user");
            VALUES("name", "#{user.name}");
            VALUES("sex", "#{user.sex}");
        }}.toString();
    }

    public String updateUser() {
        return new SQL(){{
            UPDATE("user");
            SET("name=#{user.name}");
            SET("sex=#{user.sex}");
            WHERE("name=#{user.name}");
        }}.toString();
    }

}
