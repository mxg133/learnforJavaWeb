package my;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-13 4:54 下午
 * @description
 */
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("Servlet（1）中的username -> " + username);

        //
        request.setAttribute("key", " Servlet1的信息 ");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("3.cn");

        //2
        requestDispatcher.forward(request, response);
    }
}
