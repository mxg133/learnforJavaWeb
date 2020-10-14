package test;

import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;

import static org.junit.Assert.*;

/**
 * @author 孟享广
 * @date 2020-10-14 5:02 下午
 * @description
 */
public class UserDaoImplTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("wzg168"));

    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("admin", "admin");
        System.out.println(user);
    }

    @Test
    public void saveUser() {
        System.out.println( userDao.saveUser(new User(null,"wzg168", "123456", "wzg168@qq.com")) );
    }
}