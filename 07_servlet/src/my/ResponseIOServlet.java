package my;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 孟享广
 * @date 2020-10-13 7:45 下午
 * @description
 */
public class ResponseIOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        response.setCharacterEncoding("utf-8");
//        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        System.out.println(response.getCharacterEncoding());
        writer.write("哈哈哈哈哈哈哈·······");

    }
}
