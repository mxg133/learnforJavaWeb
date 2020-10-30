package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-30 11:43 上午
 * @description
 */
public class Filter2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(" Filter2 的 前置代码 ····");
        System.out.println(" Filter2 的 线程： " + Thread.currentThread().getName());
        System.out.println(" Filter2 " + req.getParameter("username"));
        System.out.println(" Filter2 取 Filter1 保存的 key1 -> " + req.getAttribute("key1"));
        chain.doFilter(req, resp);
        System.out.println(" Filter2 的 后置代码 ····");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
