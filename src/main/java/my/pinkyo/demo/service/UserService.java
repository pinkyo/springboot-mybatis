package my.pinkyo.demo.service;

import my.pinkyo.demo.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getByName(String name);
    List<User> getByPage(int startIndex, int pageSize);
    void updateUser(User user);
}
