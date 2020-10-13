import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-13 2:59 下午
 * @description
 */
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("URI-> " + req.getRequestURI());
        System.out.println("URL-> " + req.getRequestURL());
        System.out.println("客户端IP-> " + req.getRemoteHost());
        System.out.println("请求头-> " + req.getHeader("User-Agent"));
        System.out.println("请求的方式-> " + req.getMethod());
//        System.out.println("URI-> " + req.getRequestURI());
//        System.out.println("URI-> " + req.getRequestURI());
//        System.out.println("URI-> " + req.getRequestURI());






    }
}
