package my;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.Location;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-13 8:35 下午
 * @description
 */
public class Response1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" 到此一游Response1的doGet ");
        response.setStatus(302);
        response.setHeader("Location", "http://localhost:8080/07_servlet_war_exploded/response2");
    }
}
