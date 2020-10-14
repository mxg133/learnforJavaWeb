package test;

import org.junit.Test;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import static org.junit.Assert.*;

/**
 * @author 孟享广
 * @date 2020-10-14 6:18 下午
 * @description
 */
public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null, "新月", "666888", "666888@gmain.com"));
    }

    @Test
    public void login() {
        User user = userService.login(new User(null, "admin", "admin", "admin@gmain.com"));
        System.out.println(user);
    }

    @Test
    public void existUsername() {
        boolean b = userService.existUsername("22");
        System.out.println(b);
    }
}