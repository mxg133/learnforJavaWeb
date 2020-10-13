package my;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-13 9:17 上午
 * @description
 */
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
        String username = servletContext.getInitParameter("username");
        System.out.println("username是：->" + username);
        System.out.println("password是：->" + servletContext.getInitParameter("password"));

        System.out.println("当前工程路径：->" + servletContext.getContextPath());

        System.out.println("工程绝对路径：->" + servletContext.getRealPath("/"));

        System.out.println("工程css绝对路径：->" + servletContext.getRealPath("/css"));

        System.out.println("工程imgs.1.jpg绝对路径：->" + servletContext.getRealPath("/imgs/1.jpg"));


    }
}
