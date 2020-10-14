package service;

import pojo.User;

/**
 * @author 孟享广
 * @date 2020-10-14 6:10 下午
 * @description
 */
public interface UserService {
    public void registUser(User user);

    public User login(User user);

    public boolean existUsername(String username);
}
