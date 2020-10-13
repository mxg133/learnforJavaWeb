package my;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-10-13 3:14 下午
 * @description
 */
public class ParameteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("----doPost------");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hobby[] = request.getParameterValues("hobby");

        System.out.println("用户名" + username);
        System.out.println("密码" + password);
        System.out.println("兴趣爱好" + Arrays.toString(hobby));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----doGet------");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hobby[] = request.getParameterValues("hobby");

        System.out.println("用户名" + username);
        System.out.println("密码" + password);
        System.out.println("兴趣爱好" + Arrays.toString(hobby));

    }
}
