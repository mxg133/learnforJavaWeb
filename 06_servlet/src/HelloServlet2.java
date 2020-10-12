import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-10 4:44 下午
 * @description
 */
public class HelloServlet2 extends HttpServlet {
    public HelloServlet2() {
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("重写了init方法 ing········");
    }

    /**
     * doGet（）在get请求的时候调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doGet()方法····");
    }

    /**
     * doPost（）在post请求的时候调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doPost()方法····");
    }
}
