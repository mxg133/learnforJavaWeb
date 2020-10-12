import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-10 10:07 上午
 * @description
 */
public class HelloServlet1 implements Servlet {
    //单例的 就创建一次
    public HelloServlet1() {
        System.out.println("1 Hellosservlet的构造器····");
    }

    //单例的 就创建一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 Hellosservlet的init()初始化方法····");

        System.out.println("HelloServlet1的别名是：->" + servletConfig.getServletName());

        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));

        System.out.println("初始化参数的url值是：" + servletConfig.getInitParameter("url"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //每次访问 都会调用
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 Hellosservlet的service()方法····");
        //类型转换
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求的方式
        String method = httpServletRequest.getMethod();
//        System.out.println(method);
        if ("GET".equals(method)) {
            doGet();
        }else if ("POST".equals(method)){
            doPost();
        }
    }

    public void doGet() {
        System.out.println("get请求····");
    }

    public void doPost() {
        System.out.println("post请求····");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    //停止的时候会被调用
    @Override
    public void destroy() {
        System.out.println("4 Hellosservlet的destroy()销毁方法····");
    }
}
