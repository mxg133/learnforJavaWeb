package web;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-14 7:49 下午
 * @description
 */
public class RegietServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        if ("abcde".equalsIgnoreCase(code)) {
            if (userService.existUsername(username)) {
                System.out.println("存在了！不能注册 正在跳转注册页面·····");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            }else {
                userService.login(new User(null, username, password, email));
                System.out.println("好 注册OK！ 正在跳转成功页面·····");
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        }else {
            System.out.println("不争气,,验证码不对！");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
//        request.getParameter("")

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
